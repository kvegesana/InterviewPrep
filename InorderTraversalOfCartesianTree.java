
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
    public TreeNode buildTree(ArrayList<Integer> A) {
    	return build(A,0,A.size()-1);
    }
     public TreeNode build(ArrayList<Integer> A,int l,int r) {
    	int id = max(A,l,r);
    	if(id == -1) return null;
    	TreeNode node = new TreeNode(A.get(id));
    	node.left = build(A,l,id-1);
    	node.right = build(A,id+1,r);
    	return node;
    }
    static int max(ArrayList<Integer> ar,int l,int r){
    	if(l>r) return -1;
    	int res = Integer.MIN_VALUE;
    	int idx = -1;
    	for(int i=l;i<=r;++i){
    		if(res < ar.get(i)){
    			res = ar.get(i);
    			idx = i;
    		}
    	}
    	return idx;
    }
}
