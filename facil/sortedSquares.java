/*Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.*/

class Solution {
    public int[] sortedSquares(int[] A) {
        int Arraylength = A.length, j = 0;
        while (j < Arraylength && A[j] < 0){j++;}
        int i = j-1;
        int[] out = new int[Arraylength];
        int t = 0;
        while (i >= 0 && j < Arraylength) {
            if (A[i] * A[i] < A[j] * A[j]) {
                out[t++] = A[i] * A[i];
                i--;
            } else {
                out[t++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            out[t++] = A[i] * A[i];
            i--;
        }
        while (j < Arraylength) {
            out[t++] = A[j] * A[j];
            j++;
        }
        return out;
    }
}