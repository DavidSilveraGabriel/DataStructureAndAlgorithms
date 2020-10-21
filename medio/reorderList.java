/*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.*/

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
    public void reorderList(ListNode head) {
        if(head==null) return;
        List<ListNode> out =new ArrayList<ListNode>();
        ListNode current = head;

        while(current!=null){
            out.add(current);
            current=current.next;
        }
        int start = 0, end = out.size() - 1;
        ListNode newHead = null, prev = null;
        ListNode first, last;
        // unir el nodo inicial y el final
        while(start<end){
            first = out.get(start);
            last = out.get(end);
            first.next = last;
            last.next = null;
            if(newHead == null)
                newHead = first;
            if(prev != null)
                prev.next = first;
            prev = last;   
            ++start;
            --end;
        }     
        if(start == end){
            first = out.get(start);
            first.next = null;
            if(newHead == null){newHead = first;}
            if(prev != null){prev.next = first;}
                
        }
        head = newHead;
    }
}
