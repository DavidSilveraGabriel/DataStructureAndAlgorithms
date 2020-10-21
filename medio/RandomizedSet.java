/*Implement the RandomizedSet class:

bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
Follow up: Could you implement the functions of the class with each function works in average O(1) time?

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 

Constraints:

-231 <= val <= 231 - 1
At most 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.*/

//thanks khoanam225
//Time complexity: O(1)
//Space complexity: O(N)

class RandomizedSet {
    /**
     * Approach: We will use a HashTable to achieve O(1) time complexity for insert() and remove()
     * Another array will be used to achieve O(1) in getRandom(). Because we only double the size
     * of the array when it is full, the average complexity time for insert() will remain O(1).
     *
     * The map will contain values as key and their positions in the array as value.
     * The array will contain the values themselves.
     * 
     * The trickies method will be remove(), here when we remove something, we have to 
     * remove it from both the map and the array. Since we don't need to maintain the order,
     * we can just swap the last element with the removed element to achieve O(1) time.
     */
    private Map<Integer, Integer> map;
    private int[] arr;
    private int currIdx;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new int[5];
        currIdx = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr[currIdx] = val;
        map.put(val, currIdx);
        
        currIdx++;
        if (currIdx == arr.length) resize(arr.length * 2);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || currIdx == 0) return false;
        
        int idx = map.get(val);
        map.remove(val);
        currIdx--;
        
        // Put the last element in the empty slot of the removed element
        if (currIdx != 0 && currIdx != idx) {
            arr[idx] = arr[currIdx];
            map.put(arr[idx], idx);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = (int)Math.floor(Math.random() * currIdx);
        return arr[idx];
    }
    
    private void resize(int newSize) {
        int[] newArr = new int[newSize];
        for (int i = 0; i < currIdx; i++) {
            newArr[i] = arr[i];
        }
        
        arr = newArr;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */