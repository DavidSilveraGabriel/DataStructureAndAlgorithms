/*Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character
 while preserving the order of characters. No two characters may map to
  the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.*/

//thanks to harshit_sinha
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mappedChars = new HashMap<>();
        for(int i=0;i<s.length();i++){
            //eg abc and xyx
            if(!mappedChars.containsKey(s.charAt(i))){ 
                if(mappedChars.containsValue(t.charAt(i))){
                    return false;
                }
                //if both chars in both strings does not exist in hashmap
                mappedChars.put(s.charAt(i), t.charAt(i));
            }
            //if map already contains key but not the value ( eg : add, pol)
            else if(!mappedChars.containsValue(t.charAt(i))){
                return false;       
            }
            //if map contains key, check if value for that key 
            //is same as the correponding char in the second string
            else if(mappedChars.containsKey(s.charAt(i))){
                if(t.charAt(i) != mappedChars.get(s.charAt(i))){
                    return false;
                } 
            }
        }
        return true;
    }
}
