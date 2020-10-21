/*Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.*/

public class WordDictionary {
    TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    
    private class TrieNode{
        // R links to node children
        private TrieNode[] links;
        private final int R = 26;
        private boolean isword;
        public TrieNode() {
            links = new TrieNode[R];
            isword = false;
        }
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word != null){
            TrieNode now = root;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 'a';
                if (now.links[index] == null){
                    now.links[index] = new TrieNode();
                }
                now = now.links[index];
            }
            now.isword = true;
        }
    }
    
/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null) return false;
        boolean search = searchArray(word.toCharArray(), 0, root);
        return search;
    }
    public boolean searchArray(char[] chars, int start, TrieNode node){
        TrieNode now = node;
        for (int i = start; i < chars.length; i++){
            if (now == null){
                break;
            }else{
                if (chars[i] != '.'){
                    int index = chars[i] - 'a';
                    now = now.links[index];
                }else{
                    TrieNode temp = now;
                    for (int j = 0; j < 26; j++){
                        now = temp.links[j];
                        if (searchArray(chars, i+1, now))
                            return true;
                    }
                    return false;
                }
            }
        }
        boolean result = now != null && now.isword;
        return result;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */