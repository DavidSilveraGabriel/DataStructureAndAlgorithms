/*Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.

Follow up: Could you do this in O(n) runtime?

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [0]
Output: 0
Example 3:

Input: nums = [2,4]
Output: 6
Example 4:

Input: nums = [8,10,2]
Output: 10
Example 5:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1*/

//thanks to saurabhnov93
class TreeNode{
    TreeNode left;
    TreeNode right;
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode();
        int len = nums.length; 
        insert(nums, root, len);

        return findMaximumXOR(nums, root, len);
    }
    
    public void insert(int[] nums, TreeNode head, int len){
        TreeNode curr;
        
        for(int i=0; i<len; i++){
            curr = head;

            for(int j=31; j>=0; j--){
                int bit = (nums[i]>>j)&1;

                if(bit == 0){
                    if(curr.left == null) curr.left = new TreeNode();
                    curr = curr.left;
                }else{
                    if(curr.right == null) curr.right = new TreeNode();
                    curr = curr.right;
                }
                   
            }

        }
    }
    
    public int findMaximumXOR(int[] nums, TreeNode head, int len){
        TreeNode curr;
        int curxor = 0, maxxor = Integer.MIN_VALUE;
        
        for(int i=0; i<len; i++){
            curr = head;
            curxor = 0;

            for(int j=31; j>=0; j--){

                int bit = (nums[i]>>j)&1;
            
                if(bit == 0){
                    if(curr.right != null){
                        curxor += Math.pow(2,j);
                        curr = curr.right;
                    } 
                    else curr = curr.left;
                }else{
                    if(curr.left != null){
                        curxor += Math.pow(2,j);
                        curr = curr.left;
                    } 
                    else curr = curr.right;
                }
                
            }
            if(curxor > maxxor) maxxor = curxor;
        }
        
        return maxxor;
    }
}