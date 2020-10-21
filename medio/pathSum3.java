/*You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Thansk to aniruddha_agrawal

class Solution {
	int paths = 0;// define la variable que almacena la cantidad de path que suman el valor dado
	public int pathSum(TreeNode root, int sum) {// funcion cuyas entradas sonm el arbol y un valor sum
		if (root == null) {//asegurarse de que root no sea nulo
			return 0;// si lo es devolve cero
		}
		helper(root, sum);//utiliza la funcion de ayuda definida despues
		pathSum(root.left, sum);//mirar para los  nodos de la izquierda
		pathSum(root.right, sum);//mirar para los  nodos de la derecha
		return paths;//devolver la cantidad de path que suman el valor dado 
	}
	private void helper(TreeNode R, int sum) {//define la funcion de ayuda
		if (R != null && R.val == sum){++paths;}//si el nodo no es nulo y su valor es el valor dado, contar
		if (R != null){// si el nodo no es nulo
			sum -= R.val;//restar el valor del nodo a el valor que tiene que dar 
			helper(R.left, sum);//aplicar la funcion de ayuda a los nodos de la izquierda
			helper(R.right, sum);//aplicar la funcion de ayuda a los nodos de la derecha
		}
	}
}