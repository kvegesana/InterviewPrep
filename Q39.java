import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q39 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return lists[0];
        }
        ListNode first = lists[0];
        for (int i = 1; i < n; ++i) {
            first = mergeLists(first, lists[i]);
        }
        return first;
    }

    public ListNode mergeLists(ListNode a, ListNode b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        ListNode head = new ListNode();
        ListNode node = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                ListNode root = new ListNode(a.val);
                node.next = root;
                node = node.next;
                a = a.next;
            } else {
                ListNode root = new ListNode(b.val);
                node.next = root;
                node = node.next;
                b = b.next;
            }
        }
        if (a == null) {
            node.next = b;
        }
        if (b == null) {
            node.next = a;
        }
        return head.next;
    }

    // Version 2
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return lists[0];
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ListNode list = lists[i];
            ListNode head = list;
            while (head != null) {
                ar.add(head.val);
                head = head.next;
            }
        }
        Collections.sort(ar);
        ListNode head = new ListNode();
        ListNode root = head;
        for (int i = 0; i < ar.size(); ++i) {
            int a = ar.get(i);
            ListNode node = new ListNode(a);
            head.next = node;
            head = head.next;
        }
        return root.next;
    }

    // Version 3
    public ListNode mergeKLists3(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                return o1.val - o2.val;
            }
        };

        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (!q.isEmpty()) {
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if (next != null) {
                q.add(next);
            }
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