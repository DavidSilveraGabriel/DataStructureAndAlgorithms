/*Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

Accepted*/

//thanks to ran3
class Solution {
    public String largestNumber(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);
        Collections.sort(list, (a, b) -> {
            String n1 = String.valueOf(a);
            String n2 = String.valueOf(b);
            return (n2 + n1).compareTo(n1 + n2);
        });
        StringBuilder ans = new StringBuilder();
        for(int num : list) ans.append(num);
        while(ans.length() > 1 && ans.charAt(0) == '0') ans.deleteCharAt(0);
        return ans.toString();
		
    }
}