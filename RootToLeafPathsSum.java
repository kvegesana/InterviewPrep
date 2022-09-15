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
     static ArrayList<ArrayList<Integer>> res; 
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A,int sum) {
         res = new ArrayList<ArrayList<Integer>>();
         if(A == null) return res;
         ArrayList<Integer> ar = new ArrayList<Integer>();
         build(A,sum,ar);
         return res;
    }
    static void build(TreeNode node,int sum,ArrayList<Integer> ar){
        if(node == null){
            return;
        }
        ar.add(node.val);
        if(node.left == null && node.right == null && sum == node.val){
            res.add(new ArrayList<Integer>(ar));
        }    
            build(node.left,sum-node.val,ar);
            build(node.right,sum-node.val,ar);
            ar.remove(ar.size()-1);
    }
}