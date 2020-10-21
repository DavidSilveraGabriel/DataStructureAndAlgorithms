/*Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 

Constraints:

0 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 104
0 <= t <= 231 - 1*/

//thanks to eileen98034
// O(n^2) time, O(1) space
// this solution multiplies abs by 1L to take care of possible integer overflow
/*class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(Math.abs(1L * nums[i] - nums[j]) <= t && j - i <= k)
                    return true;
            }
        }
        return false;
    }
}
*/
// O(nlogk) time, O(k) space
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        TreeSet<Integer> numSet = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer end = numSet.floor(nums[i]);
            Integer begin = numSet.ceiling(nums[i]);
            if ((end != null && (long)nums[i]-end <= t)
                || (begin != null && (long)begin-nums[i] <= t))
                    return true;
            numSet.add(nums[i]);
            if (i >= k)
                numSet.remove(nums[i-k]);
        }
        
        return false;
    }
}