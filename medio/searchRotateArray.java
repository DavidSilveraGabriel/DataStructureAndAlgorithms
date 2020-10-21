/*You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4*/


//thanks geetishnayak
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || (nums.length == 1 && nums[0] != target)){ // NULL condition
            return -1;
        }
        if(nums.length == 1 && nums[0] == target){ // Handle only 1 element
            return 0;
        }
        if(nums[0] < nums[nums.length - 1]){ // numbers do not have a pivot and the order is fine
            return bs(nums, 0, nums.length - 1, target);
        }
        // find pivot point
        int pivot = findPivotIndex(nums, 0, nums.length-1);
        if(target == nums[pivot]){
            return pivot;
        }
        else if(target > nums[pivot] && target <= nums[nums.length-1]){
            return bs(nums, pivot, nums.length - 1, target);
        }
        else{
            return bs(nums, 0, pivot - 1, target);
        }
    }

    // simple binary search
    public int bs(int[] nums, int startIndex, int endIndex, int target){
        while(startIndex <= endIndex){
            int mid = startIndex + (endIndex - startIndex)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                endIndex = mid - 1;
            }
            else{
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    public int findPivotIndex(int[] nums, int low, int high){
        int mid = low + ((high - low)/2);
        if(nums[mid] > nums[high] && (mid + 1) == high){
            return high;
        }
        if(nums[mid] < nums[low] && (low + 1) == mid){
            return mid;
        }
        if(nums[low] > nums[mid]){
            return findPivotIndex(nums, low, mid);
        }
        else{
            return findPivotIndex(nums, mid, high);
        }
    }
}