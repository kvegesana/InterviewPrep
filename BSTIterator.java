
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class Solution {
	static Stack<TreeNode> s;
    public Solution(TreeNode root) {
        s = new Stack<TreeNode>();
        while(root != null){
        	s.push(root);
        	root = root.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()){
        	return -1;
        }
        TreeNode node = s.pop();
        int val = node.val;
        node = node.right;
        while(node != null){
        	s.push(node);
        	node = node.left;
        }
        return val;
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */
