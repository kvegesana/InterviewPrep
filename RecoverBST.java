  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public ArrayList<Integer> recoverTree(TreeNode A) {
    	ArrayList<Integer> ar = new ArrayList<>();
    	build(A,ar);
    	int n = ar.size();
    	boolean f = false;
    	boolean s = false;
    	int first = -1;
    	int sec = -1;
    	int tr = -1;
    	for(int i=0;i<n-1;++i){
    		int a = ar.get(i);
    		int b = ar.get(i+1);
    		if(a > b){
    			if(!f){
    				first = a;
    				sec = b;
    				f = !f;
    			}
    			else{
    				tr = b;
    				s = !s;
    			}
    		}
    	}
    	ArrayList<Integer> res = new ArrayList<>();
    	if(s){
    		res.add(tr);
    	}
    	else {
    		res.add(sec);
    	}
    	res.add(first);
    	return res;
    }
    static void build(TreeNode node,ArrayList<Integer> ar){
    	if(node == null){
    		return ;
    	}
    	build(node.left,ar);
    	ar.add(node.val);
    	build(node.right,ar);
    }
}
