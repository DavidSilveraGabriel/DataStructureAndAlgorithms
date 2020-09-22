//PRE ORDER TRAVERSAL
class Solution {
   //iterative solution
   public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer>        result = new LinkedList<>();
       LinkedList<TreeNode> stack  = new LinkedList<>();
       stack.add(root);
       while (stack.size()>0){
           TreeNode node = stack.pop();
           if (node==null) continue;
           result.add(node.val);
           stack.push(node.right);
           stack.push(node.left);
       }
       return result;
   }
   //recursion
   public List<Integer> preorderTraversal13(TreeNode root) {
       if (root==null) return Arrays.asList();
       List<Integer> result = new LinkedList<>();
       result.add(root.val);
       result.addAll(preorderTraversal(root.left));
       result.addAll(preorderTraversal(root.right));
       return result;
   }
}

//thanks gfei2

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        LH(ans, root, 0);
        return ans;
    }
    public void LH(List<List<Integer>> out, TreeNode root, int height) {
        if (root==null) return;
        if (height >= out.size()) {
        out.add(new LinkedList<Integer>());
        }
        out.get(height).add(root.val);
        LH(out, root.left, height+1);
        LH(out, root.right, height+1);
    }

//find the maximun depth
//de arriba hacia abajo
private int answer;		// don't forget to initialize answer before call maximum_depth
private void maximum_depth(TreeNode root, int depth) {
    if (root == null) {
        return;
    }
    if (root.left == null && root.right == null) {
        answer = Math.max(answer, depth);
    }
    maximum_depth(root.left, depth + 1);
    maximum_depth(root.right, depth + 1);
}
//de abajo hacia arriba 
public int maximum_depth(TreeNode root) {
	if (root == null) {
		return 0;                                   // return 0 for null node
	}
	int left_depth = maximum_depth(root.left);
	int right_depth = maximum_depth(root.right);
	return Math.max(left_depth, right_depth) + 1;	// return depth of the subtree rooted at root
}

//arbol espejo
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
 *///Oficial answer
 class Solution {
    public boolean isSymmetric(TreeNode root) {   
        return isMirror(root, root);
        /*iterativo
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;*/
    }
    //recursivo
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}

//thanks to wuattiroro
//la suma de una fila de nodos tiene que ser igual a sum sino falso
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }    
}

//dado dos arrays de arboles binarios en forma in-order y postorder
//devolver la reconstruccion de estos
//thanks to charlie11

class Solution {
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        idx = postorder.length-1;
        TreeNode root = build(inorder, postorder, 0, idx);
        return root;
    }
    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start>end) return null;
        TreeNode node = new TreeNode(postorder[idx--]);
        if (start==end) return node;

        int index = findIdx(inorder, node.val, end);
        node.right = build(inorder, postorder, index+1, end);
        node.left = build(inorder, postorder, start, index-1);
        return node;
    }
    private int findIdx(int[] inorder, int val, int end) {
        for (int i=end; i>=0; i--) {
            if (inorder[i]==val) return i;
        }
        return 0;
    }
}



}