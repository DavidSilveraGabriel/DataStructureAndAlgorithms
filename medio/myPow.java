/*Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104*/

//thanks to vsriram
class Solution {
    public double myPow(double x, int n) {
        if(x==0){return 0;}
        if(n==0){return 1;}
        if (n>0){
            return getPower(x, n);
        }else{
            if(n== Integer.MIN_VALUE){
                n=Integer.MAX_VALUE;
                return (1/(getPower(x, n))) * (1/x);
            }else{
                n *= -1;
                return 1/(getPower(x, n));
            }
        }
    }
    
    public double getPower(double x, int n) {
        if (n == 0) {return 1;}
        return n % 2 == 0? getPower(x * x, n/2) : x * getPower(x * x, n/2);
    }
}