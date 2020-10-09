/*Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 

Example 1:

Input: arr = [2,6,4,1]
Output: false
Explanation: There are no three consecutive odds.
Example 2:

Input: arr = [1,2,34,3,4,5,7,23,12]
Output: true
Explanation: [5,7,23] are three consecutive odds.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
*/

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        int c_odd = 0;
        if(len<3){
            return false;
        }
        for(int i = 0; i < len; i++){
            if(!((arr[i])%2==0)){
                c_odd++;       
            }
            if((arr[i])%2==0) c_odd = 0;
            if(c_odd == 3) return true;
        }
        return false;
    }
}