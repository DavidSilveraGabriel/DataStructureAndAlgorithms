/*Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 

Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.*/

class MyLinkedList {
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
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */