/*Given an array of integers nums, sort the array in ascending order.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
 

Constraints:

1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000*/

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int pivot = nums.length / 2;
        int [] left_list = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int [] right_list = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left_list, right_list);
    }
    public int [] merge(int [] left_list, int [] right_list) {
        int [] ret = new int[left_list.length + right_list.length];
        int left_cursor = 0, right_cursor = 0, ret_cursor = 0;

        while (left_cursor < left_list.length && 
                 right_cursor < right_list.length) {
            if (left_list[left_cursor] < right_list[right_cursor]) {
            ret[ret_cursor++] = left_list[left_cursor++];
            } else {
            ret[ret_cursor++] = right_list[right_cursor++];
            }
        }
        // append what is remain the above lists
        while (left_cursor < left_list.length) {
            ret[ret_cursor++] = left_list[left_cursor++];
        }
        while (right_cursor < right_list.length) {
            ret[ret_cursor++] = right_list[right_cursor++];
        }  
        return ret;
    }
}
