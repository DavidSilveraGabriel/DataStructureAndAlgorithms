/*Given a non-empty array of integers, return the third maximum number in this array.
 If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.*/

class Solution {
    public int thirdMax(int[] nums) {
        int len = nums.length;//longitud del array
        int point = 0;//punto bandera para contar
        Arrays.sort(nums);//ordenar ascendentemente 
        // si la longitud es menor a 3 devolver el mas grande
        if (len < 3) {
            return nums[len - 1];
        }
        //recorrer el array desde atras o del ultimo elemento
        for (int i=len-1; i > 0; i--) {
            // si el elemento actual es distinto al elemento anterior 
            if (nums[i] != nums[i - 1]) {
                point++;//sumar 1 
            }
            // si se consigue 2 puntos devolver el elemento anterior al actual
            if (point == 2) {
                return nums[i - 1];
            }
        }
        //devolver el ultimo elemento
        return nums[len-1];
        
    }
}