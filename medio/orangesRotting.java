/*In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.*/

// Thanks to logan138
class Solution {
    public int orangesRotting(int[][] grid) {
        int minu = 0;// declara la variable minutos
        boolean already = true;//declara booleano en verdadero
        while(true){//hacer el ciclo hasta un break;
            boolean hasFresh = false;//booleano no esta fresca 
            //declara un set con una clase pair para llaves y valores
            HashSet<Pair<Integer, Integer>> set = new HashSet<>();

            for(int i = 0; i < grid.length; i++){//recorrer horizontalmente
                for(int j = 0; j < grid[0].length; j++){//recorrer verticalmente
                    if(grid[i][j] != 1) continue;//si la naranja no esta fresca o no existe continuar
                    already = false;//no esta listo
                    //checkear si existen o si estan podridas segun su direccion
                    boolean up = (i == 0) ? false : (grid[i - 1][j] == 2);
                    boolean down = (i == grid.length - 1) ? false : (grid[i + 1][j] == 2);
                    boolean left = (j == 0) ? false : (grid[i][j - 1] == 2);
                    boolean right = (j == grid[0].length - 1) ? false : (grid[i][j + 1] == 2);
                    //siempre y cuando alguna se cumpla 
                    if(up || down || left || right){
                        set.add(new Pair(i, j));//agregar un nuevo par al hashset
                    } 
                    else{hasFresh = true;}//sino significa que esta fresca
                        
                }
            }
            if(already) return 0;//si ya esta devolver vacio
            if(set.size() == 0 && hasFresh)
                return -1;//error es imposible

            for(Pair<Integer, Integer> pair : set){//para los pares de elementos en set
                int i = pair.getKey();//obtener la llave
                int j = pair.getValue();//y el valos correspondiente a la llave
                grid[i][j] = 2;//asignarle podrido
            }
            minu++;//cronometrar los minutos
            if(!hasFresh)//sino esta fresco terminar el bucle infinito
                break;
        }
        return minu;//devolver el tiempo tardado 
    }
}