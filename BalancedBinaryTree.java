/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
  //  static boolean res = true;
    public int isBalanced(TreeNode A) {
        Height he = new Height();
       return height(A,he) == false ? 0 : 1;
    }
   public boolean height(TreeNode node,Height h){
     if(node == null){
         h.h = 0;
         return true;
     }
      Height lh = new Height();
      Height rh = new Height();
      
      boolean l = height(node.left,lh);
      boolean r = height(node.right,rh);
      
      int leh = lh.h;
      int reh = rh.h;
      h.h = Math.max(leh,reh) + 1;
      if(Math.abs(leh - reh) > 1) return false;
      return l&&r;
   }
}
class Height{
    int h = 0;
}
