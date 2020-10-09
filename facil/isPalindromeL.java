/*Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?*/
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
//thanks to amanuel2

class Solution {
    ListNode node;
    public boolean isPalindrome(ListNode head) {
        node = head;
        return palindrome(head);   
    }
    public boolean palindrome(ListNode head){
        if(head == null) return true;   
        boolean palind = palindrome(head.next);
        if(palind == false) return false; 
        if(node.val == head.val){ 
            node = node.next;     
            return true;
        } 
        return false;
    }
    
}