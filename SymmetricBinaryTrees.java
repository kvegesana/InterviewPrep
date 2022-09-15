
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
    public int isSymmetric(TreeNode A) {
    	return res(A,A) ? 1 : 0;
    }
    public boolean res(TreeNode node1,TreeNode node2){
    	if(node1 == null && node2 == null) return true;
    	if(node1 == null || node2 == null) return false;
    	return node1.val == node2.val && res(node1.left,node2.right) && res(node1.right,node2.left);
    }
}
