public class Q42 {
    public static void main(String[] args) {

    }

    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        sum(root, 0);
        return sum;
    }

    public int sum(TreeNode root, int s) {
        if (root == null)
            return 0;
        int val = root.val;
        s *= 10;
        s += val;
        if (root.left == null && root.right == null) {
            sum += s;
            return 0;
        }
        sum(root.left, s);
        sum(root.right, s);
        return 0;
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