/*Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.*/

// Thanks to Gadspiro
class CombinationIterator {
    ArrayList<String> list;
    int idx;
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList();
        idx = 0;
        char[] ch = characters.toCharArray();
        StringBuilder temp = new StringBuilder();
        combination(list, 0, ch, combinationLength, temp);
    }
    public void combination(ArrayList<String> list, int idx, char[] w, int length, StringBuilder temp){
        if(length == 0){
            list.add(temp.toString());
            return;
        }
        for(int i = idx; i + length <= w.length; i++){
            temp.append(w[i]);
            combination(list, i+1, w, length-1, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    
    public String next() {
        return list.get(idx++);
    }
    
    public boolean hasNext() {
        return (idx < list.size());
    }
}
/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */