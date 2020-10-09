/*Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }*/
 
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head.next, nex=curr.next;
        head.next=null;
        while(curr!=null){
            curr.next=head;
            head=curr;
            curr=nex;
            if(nex!=null) nex=nex.next;
        }
        return head;
    }
}

// From LeetCode

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