/*Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:
Try to come up as many solutions as you can, there are at least 3 different ways 
to solve this problem.
Could you do it in-place with O(1) extra space?
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 2 * 10^4
It's guaranteed that nums[i] fits in a 32 bit-signed integer.
k >= 0*/

//bruteforce
class Solution {
    public void rotate(int[] nums, int k) {
        // speed up the rotation
        k %= nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
          previous = nums[nums.length - 1];
          for (int j = 0; j < nums.length; j++) {
            temp = nums[j];
            nums[j] = previous;
            previous = temp;
          }
        }
    }
}/*Time complexity: O(n×k). All the numbers are shifted by one step O(n) k times

Space complexity:\mathcal{O}(1)O(1). No extra space is used.*/

//Using Extra Array
class Solution {
  public void rotate(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = a[i];
    }
  }
}/*Time complexity: O(n). One pass is used to put the numbers in the new array. 
And another pass to copy the new array to the original one.
Space complexity: O(n). Another array of the same size is used.*/


//Using Cyclic Replacements
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
        int current = start;
        int prev = nums[start];
        do {
            int next = (current + k) % nums.length;
            int temp = nums[next];
            nums[next] = prev;
            prev = temp;
            current = next;
            count++;
        } while (start != current);
        }
    }
}
    
//Using Reverse
/*This approach is based on the fact that when we rotate the array k times, 
k%nk elements from the back end of the array come to the front and the rest of 
the elements from the front shift backwards.

In this approach, we firstly reverse all the elements of the array. Then, reversing the 
first k elements followed by reversing the rest n-kn−k elements gives us the required result.

Let n = 7n=7 and k = 3k=3.

Original List                   : 1 2 3 4 5 6 7
After reversing all numbers     : 7 6 5 4 3 2 1
After reversing first k numbers : 5 6 7 4 3 2 1
After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result*/

class Solution {
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }
  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
/*Time complexity: \mathcal{O}(n)O(n). nn elements are reversed a total of three times.

Space complexity: \mathcal{O}(1)O(1). No extra space is used.*/