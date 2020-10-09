/*Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false*/

//thanks to hanzhoutang
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
            Integer j = m.get(nums[i]);
            if(j != null && i - j <= k) {
                return true;
            }
            m.put(nums[i],i);
        }
        return false; 
    }
}