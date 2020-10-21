fun modify(arr, op, idx){
    //add by 1 index idx
    if(op==0){
        arr[idx] = arr[idx] + 1;
    }
    //multiply by 2 all elements
    if(op==1){
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]*2;
        }
    }
}

/*Your task is to form an integer array nums from an initial array of zeros arr that is the same size as nums.

Return the minimum number of function calls to make nums from arr.

The answer is guaranteed to fit in a 32-bit signed integer.

 

Example 1:

Input: nums = [1,5]
Output: 5
Explanation: Increment by 1 (second element): [0, 0] to get [0, 1] (1 operation).
Double all the elements: [0, 1] -> [0, 2] -> [0, 4] (2 operations).
Increment by 1 (both elements)  [0, 4] -> [1, 4] -> [1, 5] (2 operations).
Total of operations: 1 + 2 + 2 = 5.
Example 2:

Input: nums = [2,2]
Output: 3
Explanation: Increment by 1 (both elements) [0, 0] -> [0, 1] -> [1, 1] (2 operations).
Double all the elements: [1, 1] -> [2, 2] (1 operation).
Total of operations: 2 + 1 = 3.
Example 3:

Input: nums = [4,2,5]
Output: 6
Explanation: (initial)[0,0,0] -> [1,0,0] -> [1,0,1] -> [2,0,2] -> [2,1,2] -> [4,2,4] -> [4,2,5](nums).
Example 4:

Input: nums = [3,2,2,4]
Output: 7
Example 5:

Input: nums = [2,4,8,16]
Output: 8
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9*/

// thanks to chejianchao
// explicacion en español
/*Revertimos la operación:
op1: menos 1
op2: dividir por 2
Entonces podemos tener esta solución codiciosa:
intentamos dividir todos los números por 2, si el número actual% 2 == 1, entonces debemos sumar 1 operación, porque este número debe restar 1.
rehacemos todos los pasos, hasta que todos los números lleguen a 0.*/ 
class Solution {
    public int minOperations(int[] nums) {
        int out = 0;//respuesta
        while(true) {//ciclo infinito hasta
            int largerThan1 = 0;//
            boolean allzero = true;//disparador para cerrar el bucle infinito
            
            for(int i = 0; i < nums.length; ++i) {//recorrer el array
                int n = nums[i];//el numero en la posicion i
                if(n == 0) continue;//si es cero continuar 
                allzero = false;//mientras no sean todos ceros dejar en falso
                if(n > 1){
                    largerThan1 = 1;//si es mas largo que uno
                }  
                out += n % 2;//sumar los modulos de n
                nums[i] /= 2;//dividir el elemento por 2
            }
            
            out += largerThan1;//contar 
            if(allzero) break;//cuando se tenga todos ceros cerrar el bucle infinito
        }
        return out;//devolver el resultado
    }
}