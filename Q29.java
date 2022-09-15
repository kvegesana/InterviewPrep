import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q29 {
    public static void main(String[] args) {

    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Queue<Node> st1 = new LinkedList<>();
        Queue<Node> st2 = new LinkedList<>();
        while (p != null) {
            st1.add(p);
            p = p.parent;
        }
        while (q != null) {
            st2.add(q);
            q = q.parent;
        }
        Node ret = new Node();
        while (!st1.isEmpty() && !st2.isEmpty()) {
            Node l = st1.poll();
            Node r = st2.poll();
            if (l.val == r.val) {
                ret = l;
                break;
            } else {
                continue;
            }
        }
        return ret;
    }
}
