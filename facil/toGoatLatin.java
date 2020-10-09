/*A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 

 

Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 

Notes:

S contains only uppercase, lowercase and spaces. Exactly one space between each word.
1 <= S.length <= 150.*/

class Solution {
    private List<Character> vowels = Arrays.asList('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');
    private int position;
    public String toGoatLatin(String S) {
        StringBuilder sbr = new StringBuilder();
        String[] split = S.split("\\s+");
        int i = 1;
        for(String s: split){
            sbr.append(toGoatLatinWord(s, i));
            if(i != split.length) sbr.append(" ");
            i++;
        }
        return sbr.toString();
    }
    public String toGoatLatinWord(String word,int position){
        char[] charArray = word.toCharArray();
        char[] cArray = new char[position];
        for(int j=0; j<position; j++){
            cArray[j] = 'a';
        }
        if(vowels.contains(charArray[0])){

            return word+"ma"+String.valueOf(cArray);
        }
        return String.valueOf(Arrays.copyOfRange(charArray, 1, charArray.length)) + charArray[0] + "ma" + String.valueOf(cArray);
    }
}