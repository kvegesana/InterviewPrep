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
    public int sumNumbers(TreeNode A) {
      long num = 0;
      long sum = 0;
      if(A == null) return 0;
      return (int)(build(A,num,sum)%1003);
    }   
    static long build(TreeNode node,long num,long sum){
      if(node == null) return sum;
      num = (num*10 + node.val) % 1003;
      if(node.left == null && node.right == null){
        sum = (sum + num) % 1003;
        return sum;
      }
      sum = build(node.left,num,sum);
      sum = build(node.right,num,sum);
      return sum;
    }
}