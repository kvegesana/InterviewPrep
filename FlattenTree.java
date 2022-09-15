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
    public TreeNode flatten(TreeNode a) {
        if(a == null) return null;
        TreeNode l = flatten(a.left);
        TreeNode r = flatten(a.right);
        if(l != null){
            TreeNode temp = l;
            while(temp.right != null){
                temp = temp.right;
            }
            temp.right = r;
            a.right = l;
            a.left = null;
        }
        return a;
    }
}

