/*Given a non-empty array of integers, every element appears twice except for one. 
Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without
using extra memory?
Example 1:
Input: [2,2,1]
Output: 1
Example 2:
Input: [4,1,2,1,2]
Output: 4*/


//Oficial solutions
//list operation, 
/*Algorithm

Iterate over all the elements in \text{nums}nums
If some number in \text{nums}nums is new to array, append it
If some number is already in the array, remove it*/
class Solution {
  public int singleNumber(int[] nums) {
    List<Integer> no_duplicate_list = new ArrayList<>();

    for (int i : nums) {
      if (!no_duplicate_list.contains(i)) {
        no_duplicate_list.add(i);
      } else {
        no_duplicate_list.remove(new Integer(i));
      }
    }
    return no_duplicate_list.get(0);
  }
}
/*Complexity Analysis

Time complexity : O(n^2). We iterate through nums, taking O(n) time. We search the whole 
list to find whether there is duplicate number, taking O(n) time. Because search is in the 
for loop, so we have to multiply both time complexities which is O(n^2).

Space complexity : O(n). We need a list of size nn to contain elements in nums*/

////////////////////////////////////////////////////////////

/*Hash table
Iterate through all elements in nums and set up key/value pair.
Return the element which appeared only once.*/

class Solution {
    public int singleNumber(int[] nums) {
      HashMap<Integer, Integer> hash_table = new HashMap<>();
  
      for (int i : nums) {
        hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
      }
      for (int i : nums) {
        if (hash_table.get(i) == 1) {
          return i;
        }
      }
      return 0;
    }
  }
  /*We use hash table to avoid the O(n)O(n) time required for searching the elements.
  Complexity Analysis
  
  Time complexity : O(n.1)=O(n). Time complexity of for loop is O(n). Time complexity of
   hash table(dictionary in python) operation pop is O(1).
  
  Space complexity : O(n). The space required by hash_table is equal to the number of elements 
  in nums*/
  
  ////////////////////
  
  /*
  Bit Manipulation
  
  If we take XOR of zero and some bit, it will return that bit
  a ⊕ 0 = a
  If we take XOR of two same bits, it will return 0
  a ⊕ a = 0
  a ⊕ b ⊕ a = (a ⊕ a) ⊕ b = 0 ⊕ b = b
  So we can XOR all bits together to find the unique number.
  */
  class Solution {
    public int singleNumber(int[] nums) {
      int a = 0;
      for (int i : nums) {
        a ^= i;
      }
      return a;
    }
  }
  /*Complexity Analysis
  
  Time complexity : O(n). We only iterate through nums, so the time complexity is the number of elements in nums.
  
  Space complexity :O(1).
  */