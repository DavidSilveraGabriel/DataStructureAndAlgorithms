/*Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
 

Example 1:

Input: "USA"
Output: True
 

Example 2:

Input: "FlaG"
Output: False
 

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.*/

class Solution {
    public boolean detectCapitalUse(String word) {
        int cap_count = 0;
        int len = word.length();
        for(int i=0; i<len; i++){//recorro la palabra
            if(Character.isUpperCase(word.charAt(i))){//identifico si es mayuscula 
                cap_count++;    
            }
        }
        if(cap_count == 0|| cap_count == len){
            return true;
        }else if(Character.isUpperCase(word.charAt(0))&&cap_count == 1){
            return true;
        } 
        return false;
    }
}