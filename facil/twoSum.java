/*Two Sum
Given an array of integers nums and an integer target, return indices of 
the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, 
and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 105
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists. */

class twoSum {
    public int[] twosum(int[] nums, int target) {
        int len=nums.length;
        int out[];
        out = new int[2];
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }return out;
    }
}




//leetcode 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
/*Time complexity : O(n^2). For each element, we try to find its complement by looping 
through the rest of 
 array which takes O(n) time. Therefore, the time complexity is O(n^2).

Space complexity : O(1).*/

//HASHTABLE
//two pases

public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
/*Time complexity : O(n). We traverse the list containing nn elements exactly twice. 
Since the hash table reduces the look up time to O(1)O(1), the time complexity is O(n).

Space complexity : O(n). The extra space required depends on the number of items stored 
in the hash table, which stores exactly nn elements*/


//hashtable one pass
class Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
/*
Time complexity : O(n)O(n). We traverse the list containing nn elements only once. 
Each look up in the table costs only O(1)O(1) time.

Space complexity : O(n)O(n). The extra space required depends on the number of items stored 
in the hash table, which stores at most nn elements.*/