/*Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.*/


//thanks to denys19961
class MyHashMap {
	private final LinkedList<Entry>[] arr;
    private final int size;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.size = 16;
        this.arr = new LinkedList[this.size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new LinkedList<>();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = arr[hash(key)].indexOf(new Entry(key));
        if (index >= 0) {
            arr[hash(key)].get(index).val = value;
        } else {
            arr[hash(key)].add(new Entry(key, value));
        }
    }
    
    /** Returns the value to which the specified key is mapped, 
    or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = arr[hash(key)].indexOf(new Entry(key));
        return index >= 0 ? arr[hash(key)].get(index).val : -1;
    }
    /** Removes the mapping of the specified value key 
    if this map contains a mapping for the key */
    public void remove(int key) {
        arr[hash(key)].remove(new Entry(key));
    }
    /**
     * Returns true if this set contains the specified element
     */
    private boolean contains(int key) {
        return arr[hash(key)].contains(new Entry(key));
    }

    private int hash(int data) {
        return data % size;
    }
    private static class Entry {
        int val;
        int key;
        public Entry(int key) {
            this.key = key;
        }
        public Entry(int key, int val) {
            this.val = val;
            this.key = key;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry entry = (Entry) o;
            return key == entry.key;
        }
        @Override
        public int hashCode() {
            return key;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
