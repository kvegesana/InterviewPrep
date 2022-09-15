public class Q76 {
    public static void main(String[] args) {

    }

    class State {
        public int sum;
        public int count;
        public double average;

        State(int a, int b, double c) {
            sum = a;
            count = b;
            average = c;
        }
    }

    public double maximumAverageSubtree(TreeNode root) {
        return maxAve(root).average;
    }

    public State maxAve(TreeNode node) {
        if (node == null) {
            return new State(0, 0, 0);
        }
        State l = maxAve(node.left);
        State r = maxAve(node.right);

        int sum = l.sum + r.sum + node.val;
        int count = l.count + r.count + 1;

        double average = (double) ((1.0 * sum) / count);
        return new State(sum, count, Math.max(average, Math.max(l.average, r.average)));
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
}
