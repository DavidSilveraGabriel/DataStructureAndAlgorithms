/*Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.*/

class Solution {
    public int hIndex(int[] citations) {//array de citaciones
        Arrays.sort(citations);// las ordenamos de menor a mayor
        int len = citations.length;// tomamos la longitud
        int flag = 1;// ponemos una bandera en 1
        while(flag<=len){//mientras la longitud no sea menos o igual a la bandera 
            //si el elemento de la posicion calculada como la diferencia entre la longitud
            // y la bandera es menor a la bandera romper el bucle
            if(citations[len-flag]<flag) break;
            flag++;// mientras no se rompa sumar banderitas 
        }
        return flag-1;//devolver la cantidad de banderas menos 1 
    }
}