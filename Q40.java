import java.util.ArrayList;
import java.util.List;

public class Q40 {
    public static void main(String[] args) {

    }

    List<Integer> list;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        list = new ArrayList<>();
        printK(root, target, k);
        return list;
    }

    public void printDown(TreeNode root, int k) {
        if (root == null || k < 0)
            return;
        if (k == 0) {
            list.add(root.val);
            return;
        } else {
            printDown(root.left, k - 1);
            printDown(root.right, k - 1);
        }

    }

    public int printK(TreeNode root, TreeNode node, int k) {
        if (root == null)
            return -1;
        if (root == node) {
            printDown(root, k);
            return 0;
        }
        int l = printK(root.left, node, k);
        if (l != -1) {
            if (l + 1 == k) {
                list.add(root.val);
            } else {
                printDown(root.right, k - l - 2);
            }
            return l + 1;
        }
        int r = printK(root.right, node, k);
        if (r != -1) {
            if (r + 1 == k) {
                list.add(root.val);
            } else {
                printDown(root.left, k - r - 2);
            }
            return r + 1;
        }
        return -1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}