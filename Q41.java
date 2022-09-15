public class Q41 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node root = head;
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = root;
        while (head != null) {
            head.next.random = head.random.next;
            head = head.next.next;
        }
        head = root;
        Node ret = head.next;
        while (head != null) {
            Node node1 = head;
            Node node2 = head.next;
            node1.next = node2.next;
            node2.next = node2.next.next;
        }
        return ret;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}