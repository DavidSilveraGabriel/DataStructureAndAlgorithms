/*Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 

Example 1:



Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 

Constraints:

The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null; // si esta vacio devolver null
        Node head = new Node(Integer.MIN_VALUE); // head nodo

        for (Node node = root,level = head; //para el nodo y el nivel
             node != null;//mientras el nodo no sea null
             node = node.next) { //node next == i++
            
            if (node.left != null) { // si el nodo izquierdo no es nulo
                level.next = node.left;// atribuir ese valor al siguiente nivel
                level = level.next;// i++;
            }
            if (node.right != null) { // si el nodo derecho no es nulo
                level.next = node.right;// atribuir ese valor al siguiente nivel
                level = level.next; // pasar al siguiente == i++
            }
            

        }
        connect(head.next);//repetir hasta que no se pueda mas
        return root;// devolver el root
    }
}