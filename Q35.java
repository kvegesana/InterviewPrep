public class Q35 {
    public static void main(String[] args) {

    }

    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        maxGain(root);
        return max_sum;
    }

    public int maxGain(TreeNode node) {
        if (node == null)
            return 0;
        int l = Math.max(maxGain(node.left), 0);
        int r = Math.max(maxGain(node.right), 0);
        max_sum = Math.max(max_sum, node.val + l + r);
        return Math.max(l, r) + node.val;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}