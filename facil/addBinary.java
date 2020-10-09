/*Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.*/

//thanks to markivr
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder stb = new StringBuilder();

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while(i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }
}


//thanks to wilsonyqm
class Solution {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int i =0, carry = 0;
        String res = "";
        while(i<lena || i<lenb || carry!=0){
            int x = (i<lena) ? Character.getNumericValue(a.charAt(lena - 1 - i)) : 0;
            int y = (i<lenb) ? Character.getNumericValue(b.charAt(lenb - 1 - i)) : 0;
            res = (x + y + carry)%2 + res;
            carry = (x + y + carry)/2;
            i++;
        }
        return res;
    }
}