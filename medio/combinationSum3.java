/*Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations. [1,2,1] is not valid because 1 is used twice.
Example 4:

Input: k = 3, n = 2
Output: []
Explanation: There are no valid combinations.
Example 5:

Input: k = 9, n = 45
Output: [[1,2,3,4,5,6,7,8,9]]
Explanation:
1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
​​​​​​​There are no other valid combinations.
 

Constraints:

2 <= k <= 9
1 <= n <= 60*/

/*dado dos enteros uno k=la cantidad de elementos en cada fila
n=el resultado esperado para la suma de todos los elementos de cada una de las filas
devolver una matriz que contenga todas las posibles combinaciones 
de numeros del 1 al 9 que sumados sea igual a n
Input: k = 3, n = 7
Output: [[1,2,4]]

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]*/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();//almacena la matriz
        List<Integer> curr = new ArrayList<Integer>();//almacena la fila 
        helper(out, curr, k, 1, n);//repite recursivamente hasta obtener el resultado deseado
        return out;//devolver la respuesta
    }

    public void helper(List<List<Integer>> out, List<Integer> curr, int k, int start, int sum){
        if(sum<0){//solo para evietar fallas 
            return;
        }

        if(sum==0 && curr.size()==k){//en caso de tener suma 0 
            out.add(new ArrayList<Integer>(curr));//devolver un array de ceros de tamaño k
            return;
        }

        for(int i=start; i<=9; i++){//realizar un bucle desde el elemento "start" hasta 9
            curr.add(i);//agregar el elemento i a la fila actual 
            helper(out, curr, k, i+1, sum-i);//repetir el proceso la cantidad de veces necesarias
            curr.remove(curr.size()-1);//pasar a la siguiente fila 
        }
    }
}