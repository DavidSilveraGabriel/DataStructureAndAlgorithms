/*Given a string, determine if it is a palindrome, considering only alphanumeric 
characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.
Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:
Input: "race a car"
Output: false
Constraints:
s consists only of printable ASCII characters.*/

class Solution {
    public boolean isPalindrome(String s) {
        if(s==null){
            return false;
        }
        s = s.toLowerCase();
        int i=0;
        int len=s.length()-1;
        while(i<len){
            while(i<len && checkspace(s,i)){
                i++;
            }
            while(i<len && checkspace(s,len)){
                len--;
            }
            if(s.charAt(i) != s.charAt(len)){
                return false;
            }
            i++;
            len--;
        }
        return true;
    }
    public boolean checkspace(String s, int j){
        return (!((s.charAt(j)>='a' && s.charAt(j)<='z')|| (s.charAt(j)>='0'&&s.charAt(j)<='9')));
    }
}
  