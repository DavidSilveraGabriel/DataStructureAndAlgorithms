/*Given a fixed length array arr of integers, duplicate each occurrence of zero, 
shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

 

Example 1:

Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
Example 2:

Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
 

Note:

1 <= arr.length <= 10000
0 <= arr[i] <= 9*/

class Solution {
    public void duplicateZeros(int[] arr) {
        // recorre todos los elementos del array
        for (int i = 0; i < arr.length; i++){
            // de los elementos recorridos elije los que son iguales a 0
            if(arr[i]==0){ 
                // de la longitud del array
                // busca el elemento 0 y mueve el resto a la derecha
                // haciendo espacio para que el elemento 0 se duplique
                // por el hecho de que si el array no tiene elementos
                // se llena por default con 0
                for(int j=arr.length-1; j>i; j--){
                    arr[j]=arr[j-1];
                }
                i++; //pasar al siguiente elemento
            }else{
                continue;
            }
        }
    }
}