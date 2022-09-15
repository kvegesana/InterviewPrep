/* Java Program to find distance between n1 and n2
using one traversal */
public class Main {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // variable to store distance
    // between n1 and n2.
    public static int ans;

    // Function that finds distance between two node.
    public static int _findDistance(Node root, int n1, int n2) {
        if (root == null)
            return 0;
        int left = _findDistance(root.left, n1, n2);
        int right = _findDistance(root.right, n1, n2);
        // if any node(n1 or n2) is found
        if (root.value == n1 || root.value == n2) {
            // check if their is any descendant(n1 or n2)
            // if descendant exist then distance between descendant
            // and current root will be our answer.
            if (left != 0 || right != 0) {
                ans = Math.max(left, right);
                return 0;
            } else
                return 1;
        }
        // if current root is LCA of n1 and n2.
        else if (left != 0 && right != 0) {
            ans = left + right;
            return 0;
        }
        // if their is a descendant(n1 or n2).
        else if (left != 0 || right != 0)
            // increment its distance
            return Math.max(left, right) + 1;
        // if neither n1 nor n2 exist as descendant.
        return 0;
    }

    // The main function that returns distance between n1
    // and n2.
    public static int findDistance(Node root, int n1, int n2) {
        ans = 0;
        _findDistance(root, n1, n2);
        return ans;
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        // Let us create binary tree given in
        // the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                + findDistance(root, 4, 5));

        System.out.println("Dist(4, 6) = "
                + findDistance(root, 4, 6));

        System.out.println("Dist(3, 4) = "
                + findDistance(root, 3, 4));

        System.out.println("Dist(2, 4) = "
                + findDistance(root, 2, 4));

        System.out.println("Dist(8, 5) = "
                + findDistance(root, 8, 5));
    }
}
