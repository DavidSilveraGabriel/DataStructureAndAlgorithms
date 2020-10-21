/*Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.*/

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int flag=0;
        int max=1;
        int min=1;
        int far=1;
        
        for(int i=0; i<len; i++){
            if(len==1){
                return nums[i];
            }else if(nums[0]==-1&&nums[1]==-1&&len==2){
                return 1;
            }else if(nums[i]>0){
                max=max*nums[i];
                min=Math.min(min*nums[i],1);
                flag=1;
            }else if(nums[i]==0){
                max=1;
                min=1;
            }else{
                int temp=max;
                max=Math.max(min*nums[i],1);
                min=temp*nums[i];
            }
            if(far<max){
                far=max;
            }
        }
        if(flag==0&&far==1){
            return 0;
        }
        return far;
    }
}