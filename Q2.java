public class Q2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cy = 0;
        ListNode head = new ListNode();
        ListNode ret = head;
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode();
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += cy;
            node.val = sum % 10;
            cy = sum / 10;
            ret.next = node;
            ret = ret.next;
        }
        if (cy > 0) {
            ListNode node = new ListNode(cy);
            ret.next = node;
            ret = ret.next;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
