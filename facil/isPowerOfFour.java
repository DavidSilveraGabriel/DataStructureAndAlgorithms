/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?*/

class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0){ // si es cero entonces no puede ser potencia de 4
            return false;
        }
        while(num!=1){// mientras sea distinto de uno hacer
            if( num % 4 != 0){// si el modulo del numero no da cero  
                return false; // entonces no es potencia de 4   
            }
            num = num/4; //dividir por 4 
        }
        return true;
    }
} 