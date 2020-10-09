/*Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.*/

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
//Thanks to olleh423

class Solution {
    
    public int sumOfLeftLeaves(TreeNode root) { 
        if(root == null) return 0;       
        return sum(root, false);
    }
    
    private int sum(TreeNode root, boolean isLeft) {
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            if(isLeft){
                return root.val;
            }else{
                return 0;
            }
        }
        
        return sum(root.left, true) + sum(root.right, false);
    }
}