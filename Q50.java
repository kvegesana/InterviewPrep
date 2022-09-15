public class Q50 {
    public static void main(String[] args) {

    }

    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            insert.next = insert;
            return insert;
        }

        Node current = head;
        boolean isInserted = false;
        while (current.next != head) {
            Node next = current.next;
            if (isSuitablePlace(current, next, insert)) {
                current.next = insert;
                insert.next = next;
                isInserted = true;
                break;
            }
            current = next;
        }

        if (!isInserted) {
            current.next = insert;
            insert.next = head;
        }
        return head;
    }

    private boolean isSuitablePlace(Node current, Node next, Node insert) {
        return (current.val <= insert.val && insert.val <= next.val) ||
                (current.val > next.val && insert.val <= next.val) ||
                (current.val > next.val && insert.val >= current.val);
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};