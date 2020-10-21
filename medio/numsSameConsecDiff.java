/*Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
Example 3:

Input: n = 2, k = 0
Output: [11,22,33,44,55,66,77,88,99]
Example 4:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
Example 5:

Input: n = 2, k = 2
Output: [13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
 

Constraints:

2 <= n <= 9
0 <= k <= 9*/
class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if(N==1){return new int[]{0,1,2,3,4,5,6,7,8,9};}
        List<Integer> out = new ArrayList<Integer>();
        for(int i=1;i<10;i++){
            helper(N-1,i,K,out);
        }
        return out.stream().mapToInt(j->j).toArray();
    }
    public void helper(int n, int num, int k,List<Integer> out){
        if(n == 0){out.add(num); return;}
        if(num%10 + k<10){
            helper(n-1,num*10+num%10+k,k,out);
        }
        if(0<k && num%10 -k>=0){
            helper(n-1,num*10+num%10-k,k,out);
        }
    }
}