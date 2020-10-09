/*You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.*/

//thanks to flameshine
/*class Solution {
    public int numJewelsInStones(String J, String S) {
        int jewels = 0;
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) {
                ++jewels;
            }
        }
        return jewels;
    }
}*/
// thanks to riya29 for his hash map solution
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char j: J.toCharArray()){
            map.put(j,0);
        }
        for(char s:S.toCharArray()){
            if(map.containsKey(s))
                map.replace(s, map.get(s) +1);
            else
                continue;
        }
        int ans = 0;
        for(Map.Entry<Character,Integer>m : map.entrySet()){
            ans += m.getValue();
        }
        return ans;
    }
}