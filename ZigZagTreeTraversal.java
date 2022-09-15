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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(A == null) return res;
        Stack<TreeNode> q = new Stack<>();
        Stack<TreeNode> s = new Stack<>();
        q.push(A);
        boolean f = false;
        while(q.size() > 0 || s.size()>0){
            ArrayList<Integer> ar = new ArrayList<>();
            int size;
            if(!f){
                size = q.size();
                while(size-->0){
                    TreeNode node = q.pop();
                    if(node.left!= null) s.push(node.left);
                    if(node.right!= null) s.push(node.right);
                    ar.add(node.val);
                }
            }
            if(f){
                size = s.size();
                while(size-->0){
                    TreeNode node = s.pop();
                    if(node.right != null) q.push(node.right);
                    if(node.left!= null) q.push(node.left);
                    ar.add(node.val);
                }
            }
            res.add(ar);
            f = !f;
        }
        return res;
    }
}