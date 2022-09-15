  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
 }

public class Solution {
    static boolean f1 = false;
    static boolean f2 = false;
    public int lca(TreeNode A, int B, int C) {
        f1 = false;
        f2 = false;
        TreeNode res = lc(A,B,C);
        if(f1 && f2){
            return res.val;
        }
        return -1;
    }
    static TreeNode lc(TreeNode node,int a,int b){
        if(node == null) return null;
        TreeNode temp = null;
        if(node.val == a){
            f1 = true;
            temp = node;
        }
        if(node.val == b){
            f2 = true;
            temp = node;
        }
        TreeNode l = lc(node.left,a,b);
        TreeNode r = lc(node.right,a,b);
        if(temp != null) return temp;
        if(l != null && r != null) return node;
        return l != null ? l : r;
    }
}