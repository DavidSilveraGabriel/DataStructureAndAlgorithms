/*Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int len=nums.length;
        List<Integer> out=new LinkedList();
        if(len==0){
            return out;
        }
        for(int i=0;i<len;i++){
            //tomar el indice del elemento
            //necesitamos el indice i-1 para el elemento i
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0)
                out.add(index+1);
             
            //Cuando encuentre un número i, gire el número en la posición i-1 a negativo.
            else
            nums[index] = -nums[index];
        }
        return out;
    }
}