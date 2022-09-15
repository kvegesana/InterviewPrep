public class Q70 {
    public static void main(String[] args) {

    }

    public class TreeNode {
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

    public int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxGain(root);
        return max_sum;
    }

    public long maxGain(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        long l = maxGain(root.left);
        long r = maxGain(root.right);

        long retval = Math.max(root.val, Math.max(l + root.val, r + root.val));
        long updval = Math.max(root.val + l + r, Math.max(l, r));

        max_sum = (int) Math.max(max_sum, Math.max(retval, updval));
        return retval;
    }
}
