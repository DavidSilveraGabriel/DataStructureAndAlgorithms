/*Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

//Approach 1: Dynamic Programming
/*If we have the a row of Pascal's triangle, we can easily compute the next row by each pair of adjacent values.

*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
/*Time complexity : O(numRows^2)

Although updating each value of triangle happens in constant time, it is
performed O(numRows^2) times. To see why, consider how many overall loop 
iterations there are. The outer loop obviously runs numRowsnumRows times, 
but for each iteration of the outer loop, the inner loop runs rowNumrowNum times. 
Therefore, the overall number of triangle updates that 
occur is numRows1+2+3+…+numRows, which, according to Gauss' formula, is

Space complexity : O(numRows^2)
Because we need to store each number that we update in triangle,
 the space requirement is the same as the time complexity.*/
