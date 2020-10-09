/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
eturn the length of last word (last word means the last appearing word if we loop from left to right)
in the string.
If the last word does not exist, return 0.
Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:
Input: "Hello World"
Output: 5*/

//thanks to arein

class Solution {
    public int lengthOfLastWord(String s) {
        String[] parts = s.split(" ");
        if (parts.length == 0){
            return 0;
        } 
        return parts[parts.length - 1].length();//longitud del ultimo elemento
    }
}