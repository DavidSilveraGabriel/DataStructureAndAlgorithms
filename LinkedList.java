// Definition for singly-linked list.
public class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}

// double linked list 

class MyLinkedList {

    private int size;
    private Node head, tail;
    
    protected class Node {
        int val;
        Node next;
        Node prev;
        public Node (int val) {
            this.val = val;
        }
    }
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    protected Node getNthNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head.next;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count += 1;
        }
        return current;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getNthNode(index).val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node first = new Node(val);
        first.next = head.next;
        first.prev = head;
        head.next.prev = first;
        head.next = first;
        size += 1;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node last = new Node(val);
        last.next = tail;
        last.prev = tail.prev;
        tail.prev.next = last;
        tail.prev = last;
        size += 1;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        else if (index == 0) {
            addAtHead(val);
            return;
        }
        else {
            Node first = getNthNode(index);
            Node pre = first.prev;
            Node added = new Node(val);
            pre.next = added;
            added.prev = pre;
            added.next = first;
            first.prev = added;
        }
        size += 1;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
       if(index < 0 || index >= size){
            return;
        }
        Node first = getNthNode(index);
        Node pre = first.prev;
        Node next = first.next;
        pre.next = next;
        next.prev = pre;
        size--;
    }


// other double linked list
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */class MyLinkedList {
    /* Create the node */
    class Node{
        
        int value;
        Node prev;
        Node next;
        Node(){};
        Node(int value, Node prev, Node next){
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
        
    }
    
    int len;
    Node head;
    Node tail;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        Node head = null;
        Node tail = null;
        len = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= len){
            return -1;
        }
        Node curnode = head;
        while(index-- !=0){
            curnode = curnode.next;
        }
        return curnode.value;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newnode = new Node(val,null,head);
        
        if(head == null){
            head = newnode;
            tail = newnode;
        }else{
            head.prev = newnode;
            head = newnode;
        }
        len++;
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newnode = new Node(val,tail,null);
        
        if(tail == null){
            head = newnode;
            tail = newnode;
        }else{
            tail.next = newnode;
            tail = newnode;
        }
        len++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > len || index < 0){
            return;
        }
        
        if(index==len){
            addAtTail(val);
            return;
        }else if(index==0){
            addAtHead(val);
            return;
        } 
        
        Node curnode=head;
        while(index-- !=0){
            curnode = curnode.next;
        }
        Node newnode = new Node(val, curnode.prev, curnode);
        curnode.prev.next = newnode;
        curnode.prev = newnode;
        len++;
        return;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= len || index < 0){
            return;
        } 
        
        if(index == 0){
            head = head.next;
            if(head != null) head.prev = null;
            return;
        }else if(index == len - 1){
            tail = tail.prev;
            tail.next = null;
            len--;
            return;
        } 
        
        Node curnode = head;
        while(index-- != 0){
            curnode = curnode.next;
        }
        curnode.prev.next = curnode.next;
        curnode.next.prev = curnode.prev;
        len--;
        return;
    }
}




////////////////////////
//problem 
public class Solution_a {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet();
        ListNode node=head;
        while(node!=null)
        {
            if(set.contains(node))
                return true;
            set.add(node);
            node=node.next;
        }
        return false;
        
    }
}

public class Solution_b {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        
        if(fast.next != null)
            fast = fast.next;
        else
            return false;
        
        while(fast.next != null){
            fast = fast.next;
            if(fast.val == slow.val)
                return true;
            slow = slow.next;
            
            if(fast.next != null)
                fast = fast.next;
        }
        
        return false;
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position 
(0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the
linked list.*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) {return false;}  //verifica que nunguna sea null

        ListNode p_1= head; // primer bandera
        ListNode p_2= head.next; // segunda bandera (ambas inicializadas como ListNode)
        if(p_2.next!=null){
            p_2=p_2.next;
        }else{
            return false;
        }
        while(p_2.next != null){ // mientras la segunda bandera no sea null hacer... 
            p_2=p_2.next; //pasar al siguiente nodo y asignar a la bandera 2(equivale a un ++)
            
            if(p_2.val==p_1.val){ // mirar si las banderas se encontraron
                return true;
            }
            p_1=p_1.next;//equivale a un++
            
            if(p_2.next!=null){
            p_2= p_2.next; // hacer el siguiente pase osea el segundo paso de la bandera rapida
        }
        }return false;
    }
}

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.

 

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) {return null;}// fijarse que el entero pos no sea invalido
        HashSet<ListNode> p_1= new HashSet<>(); // crear un hashset para los valors del nodo
        while(head != null){ //mientras el entero pos no sea nulo
            if(p_1.contains(head)){ //si el hashset contiene a pos
                return head;// devolver pos
            }
            p_1.add(head);
            head=head.next;
        }
        return null;
    }
}
// Intersection of Two Linked Lists
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    HashSet<ListNode> hs=new HashSet<ListNode>();
    //adding each reference of node of list A into the hashset
    while(headA!=null)
    {
        hs.add(headA);
        headA=headA.next;
    }
    while(headB!=headA || headB!=null)
    {
        //if hashset contains same reference then intersection has occured
        if(hs.contains(headB))
            break;
        headB=headB.next;
    }
    return headB;
}


//Remove Nth Node From End of List
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp = head;
        int len = 0;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        if(len == n)
            return head.next;
        
        temp = head;
        int i = 0;
        
        while(i != len - n - 1){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        
        return head;    
    }
}


// reverse linkedlist

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode current = head.next;
        ListNode next = current.next;
        head.next = null;
        while(current != null){
            current.next = head;   
            head = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }
        return head;
    }
}
///////////
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode newHead = reverseList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
}

//removeElements
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;//checkear si esta vacio
        ListNode temp = head;//poner copia 1
        ListNode tal = head;//poner copia 2
        while(head!=null){//recorrer el linked list hasta que sea uno
            if(head.val==val){//si el valor del linked list es igual al que se quiere eliminar
                if(head == temp && tal == head){//checkear que las copias sean igual que el original
                    temp = temp.next;// la copia 1 pasa a su siguiente nodo
                    head = head.next;// la original pasa a su siguiente nodo
                    tal = head;//la copia dos adquiere el valor del original
                }else{
                    //el siguiente nodo del original se lo agregamos al siguiente de la copia
                    //y al original hacemos que pase a su siguiente nodo 
                    tal.next = head.next;
                    head = head.next;
                }
            }else{//si no se encuentra el valor a eliminar 
                tal = head;//copial el original
                head = head.next;//y pasar al siguiente nodo
            }

        }
        return temp;//devolver el linked list limpio 
    }
}

//Odd Even Linked List
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 

Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].
*/
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
/*Palindrome Linked List

Solution
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?*/

class Solution {
    ListNode node;
    public boolean isPalindrome(ListNode head) {
        node = head;
        return palindrome(head);   
    }
    
    public boolean palindrome(ListNode head){
        if(head == null) return true;
        
        boolean pal = palindrome(head.next);
        
        if(pal == false) return false; //if at one point false , then keep returning false
        
        if(node.val == head.val){ //If the very end call stack is same as first
            node = node.next;     // then current itteration is a palindrome
            return true;
        } 
        return false;
    }
    
}

//Merge Two Sorted Lists
/*
Solution
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
}


