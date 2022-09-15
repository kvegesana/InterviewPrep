import java.util.Stack;

public class Q28 {
    public static void main(String[] args) {

    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    // Stack<Node> st = new Stack<>();

    // public Node treeToDoublyList(Node root) {
    // if (root == null)
    // return null;
    // inOrder(root);
    // for (int i = 0; i < st.size(); ++i) {
    // System.out.println(st.get(i).val);
    // }

    // root = st.get(0);
    // Node head = root;
    // for (int i = 1; i < st.size(); ++i) {
    // Node node = st.get(i);
    // root.right = node;
    // node.left = root;
    // root = node;
    // }
    // head.left = root;
    // root.right = head;
    // return head;
    // }

    // public void inOrder(Node root) {
    // if (root == null)
    // return;
    // inOrder(root.left);
    // st.add(root);
    // inOrder(root.right);
    // }
    class Solution {
        // the smallest (first) and the largest (last) nodes
        Node first = null;
        Node last = null;

        public void helper(Node node) {
            if (node != null) {
                // left
                helper(node.left);
                // node
                if (last != null) {
                    // link the previous node (last)
                    // with the current one (node)
                    last.right = node;
                    node.left = last;
                } else {
                    // keep the smallest node
                    // to close DLL later on
                    first = node;
                }
                last = node;
                // right
                helper(node.right);
            }
        }

        public Node treeToDoublyList(Node root) {
            if (root == null)
                return null;

            helper(root);
            // close DLL
            last.right = first;
            first.left = last;
            return first;
        }
    }
}
