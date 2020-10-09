/*Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list 
of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. 
If there is a choice tie between answers, output all of them with no order requirement. 
You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" 
with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.*/

//HashMap 
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap < Integer, List < String >> map = new HashMap < > ();
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    if (!map.containsKey(i + j))
                        map.put(i + j, new ArrayList < String > ());
                    map.get(i + j).add(list1[i]);
                }
            }
        }
        int min_index_sum = Integer.MAX_VALUE;
        for (int key: map.keySet())
            min_index_sum = Math.min(min_index_sum, key);
        String[] res = new String[map.get(min_index_sum).size()];
        return map.get(min_index_sum).toArray(res);
    }
}
/*Time complexity : O(l_1*l_2*x). Every item of list1 is compared with all the items of list2, 
l1 and l2 are the lengths of list1 and list2 respectively. And x refers to average string length.

Space complexity : O(l_1*l_2*x). In worst case all items of list1 and list2 are same. In that case,
hashmap size grows upto l1*l2*x, where x refers to average string length.*/

///whitout hashmap


public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List < String > res = new ArrayList < > ();
        for (int sum=0;sum<list1.length+list2.length-1;sum++) {
            for (int i = 0; i <= sum; i++) {
                if (i < list1.length &&sum - i < list2.length &&list1[i].equals(list2[sum - i]))
                    res.add(list1[i]);
            }
            if (res.size() > 0)
                break;
        }
        return res.toArray(new String[res.size()]);
    }
}
/*
Time complexity : O((l_1+l_2)^2*x). There are two nested loops upto l1+l2 and string comparison 
takes x time. Here, x refers to the average string length.

Space complexity : O(r*x). res list is used to store the result. Assuming r is the length of res.
*/

//using hashmap linear
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap < String, Integer > map = new HashMap < String, Integer > ();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List < String > res = new ArrayList < > ();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
/*
Time complexity : O(l_1+l_2). Every item of list2list2 is checked in a map of list1.l1 and l2 are the lengths of list1 and list2 respectively.

Space complexity : O(l_1*x). hashmap size grows upto l1*x, where x refers to average string length.*/