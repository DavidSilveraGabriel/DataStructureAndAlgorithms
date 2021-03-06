/*Given an integer rowIndex, return the rowIndexth row of the Pascal's triangle.
Notice that the row index starts from 0.
In Pascal's triangle, each number is the sum of the two numbers directly above it.
Follow up:
Could you optimize your algorithm to use only O(k) extra space?
Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:
Input: rowIndex = 0
Output: [1]
Example 3:
Input: rowIndex = 1
Output: [1,1]
Constraints:
0 <= rowIndex <= 40*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> out = new ArrayList<>();// crear una nueva lista donde guardar los enteros
        // hacer la cantidad de bucles necesarios hasta ser igual a 
        // la cantidad de columnas dadas por el rowIndex 
        for(int i = 0; i <= rowIndex; i++){
            // guardar la longitud de la lista que se agranda con cada bucle
            int len = out.size();
            // recorrer la longitud de la lista(recordando que empieza desde la posicion 0)
            for(int j = 0; j < len-1; j++){
                // agregar a la lista la suma de los elementos en 
                // la posicion 0 y la siguiente(1) como en el gif
                out.add(out.get(0)+out.get(1));
                // remover el elemento en la posicion 0
                out.remove(0);
            }
            // agregar al array el elemento de la posicion 1
            out.add(1);
        }
        //devolver el array 
        return out; 
    }
}