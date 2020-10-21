/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3*/

//thanks to wcyz666 and to GrubenM for his refactorizing 

/**
 * Dado un mapa cuadriculado 2d de '1's (islas) y '0's (agua),
 * contar el numero de islas.
 * 
 * Este método aborda el problema como una búsqueda de componentes
 * conectados en profundidad
 * @param grid, la cuadricula dada.
 * @return el numero de islas.
 */
class Solution {
    int y;          // La altura de la cuadricula dada
    int x;          // El ancho de la cuadricula dada
    char[][] g;     // La cuadrícula dada, almacenada para reducir el uso de memoria de recursividad

    public int numIslands(char[][] grid) {
        // Guardar la cuadricula dada
        // Esto previene tener copias en la recursion
        g = grid;
        // El numero de islas
        int c = 0;
        
        // Dimensiones del gráfico dado
        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;
        
        // Itera sobre toda la cuadrícula dada
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    c++;
                }
            }
        }
        return c;
    }
/**
 * Marca el sitio dado como visitado y luego verifica los sitios adyacentes.
 * 
 * O, marcar los sitios dados como agua y si es tierra, luego marca los sitios adyacentes.
 * 
 * O, dada la coordenada (i,j) de una isla, destruye la isla
 * de la cuadrícula dada, para que no se vuelva a contar.
 * 
 * @param i, el índice de fila de la cuadrícula dada
 * @param j, el índice de columna de la cuadrícula dada
 */
    private void dfs(int i, int j) {
        
        // Verifique índices no válidos y sitios que no sean tierra
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;
        
        // Marcar el sitio como visitado
        g[i][j] = '0';
        
        // Verifique todos los sitios adyacentes
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}