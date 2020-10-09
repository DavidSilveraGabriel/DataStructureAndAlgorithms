/*Given an integer n, add a dot (".") as the thousands separator and return it in string format.

 

Example 1:

Input: n = 987
Output: "987"
Example 2:

Input: n = 1234
Output: "1.234"
Example 3:

Input: n = 123456789
Output: "123.456.789"
Example 4:

Input: n = 0
Output: "0"
 

Constraints:

0 <= n < 2^31*/

class Solution {
    public String thousandSeparator(int n) {
        String out = Integer.toString(n);
        StringBuffer otro = new StringBuffer(out);
        int len=out.length();
        int i=len-3;
        while(i>0){
            otro.insert(i,'.');
            i-=3;
        }
        if(out=="0"||len<=3) {
            return out;
        }else{
            return otro.toString();
        }
    }

}