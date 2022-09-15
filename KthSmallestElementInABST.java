
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
    static int k;
    static int res = 0;
    public int kthsmallest(TreeNode A, int B) {
        k = 1;
        kth(A,B);
        return res;
    }
    static void kth(TreeNode node,int B){
        if(node == null) return ;
        kth(node.left,B);
        if(k != B){
            k++;
        }
        else{
            res = node.val;
            k++;
        }
        kth(node.right,B);
    }
}

