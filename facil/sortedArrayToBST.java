/*Given an array where elements are sorted in ascending order, convert it to a
height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which 
the depth of the two subtrees of every node never differ by more than 1.
Example:
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5*/

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//thanks to anshuman_bits
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {    
        return ans(nums,0,nums.length-1);
    }
    public static TreeNode ans(int[] nums, int st, int end){
        if(st>end) return null;
        if(st==end){
            TreeNode temp=new TreeNode(nums[st],null,null);
            return temp;
        }
        int mid=st+(end-st)/2;
        TreeNode temp=new TreeNode(nums[mid],null,null);
        
        temp.left=ans(nums,st,mid-1);
        temp.right=ans(nums,mid+1,end);
        
        return temp;
    }
}