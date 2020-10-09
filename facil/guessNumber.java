/*We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results:

-1: My number is lower
1: My number is higher
0: Congrats! You got it!
 

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
Example 4:

Input: n = 2, pick = 2
Output: 2
 

Constraints:

1 <= n <= 231 - 1
1 <= pick <= n*/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */
//thanks saiyancoder 
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        while(min<max) {
        int mid = min+(max-min)/2;
        if(guess(mid)>0)
            min=mid+1;
        else
            max = mid;
		}
        return min;
    }
}