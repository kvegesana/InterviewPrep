
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public class Solution {
  	HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
    	buildMap(A);
    	Inorder ir = new Inorder();
    	ir.inorder = B.size() - 1;
		return build(B,ir,0,B.size()-1);
    }
    static TreeNode build(ArrayList<Integer> ar,Inorder ir,int l,int r){
    	if(l>r) return null;
    	int idx = map.get(ir.inorder);
    	ir.inorder--;
    	TreeNode node  = new TreeNode(ar.get(idx));
    	if(l==r) return node;
    	node.left = build(ar,ir,l,idx-1);
    	node.right = build(ar,ir,idx+1,r);
    }
    static void buildMap(ArrayList<Integer> ar){
    	int n = ar.size();
    	for(int i=0;i<n;++i){
    		map.push(ar.get(i),i);
    	}
    }
}
class Inorder{
	int inorder = 0;
}