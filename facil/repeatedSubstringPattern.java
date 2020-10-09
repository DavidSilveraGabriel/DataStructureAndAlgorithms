/*Given a non-empty string check if it can be constructed by taking a substring of
 it and appending multiple copies of the substring together. You may assume the given 
 string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:

Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:

Input: "aba"
Output: False
Example 3:

Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)*/

//Thanks to lkjhlkjhasdf1
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i=len/2;i>0;i--){
            if(len%i==0){
                int j=0;
                while(j+i<len&& s.charAt(j)==s.charAt(j+i)){
                    j++;
                }
                if(j+i==len){
                    return true;
                }
            }
        }
        return false;
    }
}