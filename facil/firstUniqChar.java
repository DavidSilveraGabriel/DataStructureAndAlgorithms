/*Given a string, find the first non-repeating character in it and return its index. 
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.*/

//leet code linear solution with hashmap
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
}
/*Time complexity : O(N) since we go through the string of length N two times.
Space complexity : O(1) because English alphabet contains 26 letters.*/

//with a fixed array 

class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {            
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
                
        }
        return -1;
    }
}
//whit less extra space 
class Solution {
    public int firstUniqChar(String s) {
        int[] a = new int[26];   
        for (int i = 0; i < s.length(); ++i)
            a[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); ++i) {
            if (a[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}