/*An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9*/
//thanks to aniruddha_agrawal
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String s = "123456789";
		List<Integer> numbers = new ArrayList<>();
		int len = 2;
        while(len < 10) {
			for(int idx = 0; idx + len < 10; idx++){
				int number = Integer.parseInt(s.substring(idx, idx + len));
                helper(numbers,number,low,high);
			}
            ++len;
		}
		return numbers;
    }
    public List<Integer> helper(List<Integer> list, int num, int low, int high){
        if (num >= low) {
            if (num <= high) {
                list.add(num);
            }
            else {
                return list;
            }
        }
        return list;
    }
}