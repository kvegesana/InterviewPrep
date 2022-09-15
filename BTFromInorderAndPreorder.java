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
    static HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        Inorder ir = new Inorder();
        ir.inorder = 0;
        buildMap(B);
        return build(A,B,0,B.size()-1,ir);
    }
    static TreeNode build(ArrayList<Integer> A,ArrayList<Integer> B,int l,int r,Inorder ir){
        if(l>r) return null;
        int idx = map.get(A.get(ir.inorder));
        TreeNode node = new TreeNode(B.get(idx));
        ir.inorder++;
        if(l==r) return node;
        node.left = build(A,B,l,idx-1,ir);
        node.right = build(A,B,idx+1,r,ir);
        return node;
    }
    static void buildMap(ArrayList<Integer> ar){
        int n = ar.size();
        for(int i=0;i<n;++i){
            map.put(ar.get(i),i);
        }
    }
}
class Inorder{
    int inorder = 0;
}
