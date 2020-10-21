/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/

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
 *///thanks gfei2

 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LH(ans, root, 0);
        return ans;
    }
    public void LH(List<List<Integer>> out, TreeNode root, int height) {
        if (root==null) return;
        if (height >= out.size()) {
        out.add(new LinkedList<Integer>());
        }
        out.get(height).add(root.val);
        LH(out, root.left, height+1);
        LH(out, root.right, height+1);
    }
}