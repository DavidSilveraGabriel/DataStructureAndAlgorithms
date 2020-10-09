/*Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of
 the squares of its digits, and repeat the process until the number equals 
 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
 Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1*/

//thanks to ganlana
class Solution{
	public int BitSum(int x) {
		int sum = 0, cur;
		while(x > 0) {
			cur = x % 10;
			sum += cur*cur;
			x = x / 10;
		}
		return sum;
	}
	public boolean isHappy(int n) {
		Set<Integer>seen = new HashSet<Integer>();
		seen.add(n);
		while(n != 1) {
			n = BitSum(n);
			if(seen.add(n) == false) {
				return false;
			}
		}
		return true;
	}
}
//thanks to evermost
class Solution {
    
    private HashSet <Integer> ok = new HashSet <Integer>();
    
    public boolean isHappy(int n) {
        
        if (n == 1) {
            return true;
        }
        
        int sum = 0;
        while (n > 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        
        if (ok.contains(sum)) {
            return false;
        } else {
            ok.add(sum);
        }
        
        return isHappy(sum);
    }
}
//thanks to amanuel2 for his math solution  

class Solution {
    
    //setup constant variables
    int max_itter = 20; //change this to ur liking. (lower = faster)
    boolean bool = false;
    
    public boolean isHappy(int n) {
        return recur(digits(n));
    }
    
    
    public boolean recur(int[] nums){
        int num = 0;
        //add up each number
        for(int _num: nums){
            num+= (int)(Math.pow(_num,2));
        }
        
        //if 1 then true
        if(num == 1){
            bool = true;
            return bool;
        }
        
        //if max itterations didnt reach
        //0 then keep on with recursion.
        //this max is modifiable via line #4
        max_itter--;
        if(max_itter!=0)
            recur(digits(num));
        
        return bool;
    }
    
    public int[] digits(int num){
        //total num of digits at first
        int num_digits = (int)Math.log10(num)+1;
        int[] arr = new int[num_digits];
        
        for(int i=num_digits-1; i>=0; i--){
            //tmp divisor
            int tmp = num/((int)Math.pow(10,i));
            //add in reverse, as well as in the array
            arr[(num_digits-1) -i] = tmp%(10);
        }
        return arr;
    }
}