/*Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:



Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 

Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.*/

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
//thanks to jonnakutin

class Solution {
    
    int leftMost; int rightMost;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        leftMost = 0;
        rightMost = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        helper(root, 0, 0, map);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=leftMost; i<=rightMost; i++){
            List<Integer> arr = new ArrayList<>();
            List<int[]> list = map.get(i);
            // sorting based on level and order
            Collections.sort(list, (a,b) -> a[0] ==b[0] ? a[1] - b[1] : a[0] - b[0]);
            for(int [] rec: list){
                arr.add(rec[1]);
            }
            lists.add(arr);
        }
        
        return lists;
    }
    void helper(TreeNode root, int index, int level, Map<Integer, List<int[]>> map){
        if(root == null){
            return ;
        }
        leftMost = Math.min(leftMost, index);
        rightMost = Math.max(rightMost, index);
        map.computeIfAbsent(index, x -> new ArrayList<>()).add(new int[]{level, root.val});
        helper(root.left, index-1, level+1, map);
        helper(root.right, index+1, level+1, map);
        
    }
}