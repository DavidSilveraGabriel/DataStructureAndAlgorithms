/*Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5*/

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