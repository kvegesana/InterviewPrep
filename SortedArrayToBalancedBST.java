
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
    	return build(a,0,a.size()-1);
    }
    static TreeNode build(List<Integer> ar,int l,int r){
    	if(l>r) return null;
    	int mid = l + (r - l) / 2;
    	TreeNode node = new TreeNode(ar.get(mid));
    	node.left = build(ar,l,mid-1);
    	node.right = build(ar,mid+1,r);
    	return node;
    }
}
