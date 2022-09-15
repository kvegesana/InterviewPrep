import java.util.List;

public class Q80 {
    class SinglyLinkedListNode {
        String data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode() {

        }
    }

    public static SinglyLinkedListNode getShoppingCart(SinglyLinkedListNode head, List<List<String>> queries) {
        SinglyLinkedListNode node = head;
        SinglyLinkedListNode tail = head;
        while (node.next != null) {
            node = node.next;
        }
        tail = node;
        int size = queries.size();
        for (int i = 0; i < size; ++i) {
            List<String> list = queries.get(i);
            String op = list.get(0);
            String data = list.get(1);
            if (op.equals("PUSH_HEAD")) {
                SinglyLinkedListNode nd = new SinglyLinkedListNode();
                nd.data = data;
                nd.next = head;
                head = nd;
                if (tail == null) {
                    tail = head;
                }
            } else if (op.equals("PUSH_TAIL")) {
                SinglyLinkedListNode nd = new SinglyLinkedListNode();
                nd.data = data;
                if (tail != null) {
                    tail.next = nd;
                }
                tail = nd;
                if (head == null)
                    head = tail;
            } else {
                head = head.next;
                if (head == null)
                    tail = null;
            }
        }
        return head;
    }
}
