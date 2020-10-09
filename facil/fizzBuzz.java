/*Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and 
for the multiples of five output “Buzz”. For numbers which are multiples of both 
three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]*/

//thanks to Knowledge Center
class Solution {
    public List<String> fizzBuzz(int n) {
        String[] out = new String[n];
        for(int i=1; i<n+1;i++){
            if(i%15==0){
                out[i-1] ="FizzBuzz";
            }else if(i%5==0){
                out[i-1] ="Buzz";
            }else if(i%3==0){
                out[i-1] ="Fizz";
            }else{
                out[i-1]=Integer.toString(i);
            } 
        }
        return Arrays.asList(out);
    }
}