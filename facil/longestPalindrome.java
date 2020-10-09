/*Given a string s which consists of lowercase or uppercase letters, 
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consits of lower-case and/or upper-case English letters only.*/

//Thanks to Knowledge Center
class Solution {
    public int longestPalindrome(String s) {
        //crear un hashmap con caracteres como llaves y sus respectivos id
        Map<Character,Integer> map = new HashMap();
        //un bucle que agrega los caracteres del string al hashmap
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int out=0;//declarar la salida como un entero
        boolean odd = false;//un booleano para contar la longitud del palindromo mas grande 
        for(int i:map.values()){
            if(i%2==0){
                out += i;
            }else{
                odd=true;
                out+=i-1;
            }
        }
        if(odd){
            out++;
        }
        return out;
    }
}