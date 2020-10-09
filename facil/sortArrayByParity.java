/*Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000 */

class Solution {
    public int[] sortArrayByParity(int[] A) {
       if (A == null) {//mirar si no esta vacio
          return A;//y devolverlo en caso de estarlo
        }
        int len = A.length;//computar la longitud en un entero
        int flag = 0;// crear una bandera
        for(int i=0;i<len&&flag<len;i++){//recorrer el array 
            if((A[i])%2==0){//mirar si el elemento es par
                //computar el elemento seleccionado por la bandera en un nuevo entero
                int o = A[flag];
                //asignar el valor par a la posicion de la bandera moviendolo asi <---
                A[flag] = A[i];
                //asignar el entero a la posicion actual del recorrido
                A[i] = o;
                //aumentar la bandera en uno, pasando al siguiente elemento como un i++
                flag++;
            }
        }
        return A;//devolver el array reordenado in-place
    }
}