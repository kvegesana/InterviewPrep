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
  static int res;
    public int minDepth(TreeNode A) {
      res = Integer.MAX_VALUE;
      build(A,1);
      return res;
    }
    static void build(TreeNode node,int h){
      if(node == null) {
        return ;
      }
      if(node.left == null && node.right == null){
        res = Math.min(res,h);
      }
      build(node.left,h+1);
      build(node.right,h+1);
    }
}