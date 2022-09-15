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
    public int hasPathSum(TreeNode A,int sum) {
    	if(A == null){
    		if(sum ==0) return 1;
    		return 0;
    	}
    	if(A.left == null && A.right == null){
    		if(A.val == sum) return 1;
    		return 0;
    	}
    	int res = 0;
    	if(A.left != null){
    		res = hasPathSum(A.left,sum-A.val);
    	}
    	if(A.right != null && res == 0){
    		res = hasPathSum(A.right,sum-A.val);
    	}
    	return res == 1 ? 1 : 0;
    }
}