
class RevEntire {
    public static boolean isPalindrome(ListNode head) {
        ListNode headroot = new ListNode(head.data);
        ListNode head2 = headroot;
        ListNode node = head;
        node = node.next;
        while (node != null) {
            ListNode pop = new ListNode(node.data);
            head2.next = pop;
            node = node.next;
            head2 = head2.next;
        }
        head2 = headroot.next;
        head2 = reverse(head2);
        return compareLists(head, head2);
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return prev;
    }

    static boolean compareLists(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data == temp2.data) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            } else
                return false;
        }

        /* Both are empty return 1 */
        if (temp1 == null && temp2 == null)
            return true;

        /*
         * Will reach here when one is NULL
         * and other is not
         */
        return false;
    }

    public static void main(String[] args) {
        int n = 15;
        int[] ar = new int[n];
        ar[0] = 2;
        for (int i = 1; i < n; ++i) {
            ar[i] = ar[i - 1] * 2;
        }
        for (int i = 0; i < n; ++i) {
            int len = ar[i];
            ListNode head = new ListNode(1);
            ListNode root = head;
            for (int j = 0; j < len; ++j) {
                ListNode node = new ListNode(1);
                head.next = node;
                head = head.next;
            }

            long start = System.nanoTime();
            // System.out.println(isPalindrome(root));
            long end = System.nanoTime();
            double time = (double) (end - start) / 1_000_000;
            System.out.println(time);
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int data;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.data = val;
    }

    ListNode(int val, ListNode next) {
        this.data = val;
        this.next = next;
    }
}
