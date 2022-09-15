// Java program for the above approach
public class Sol {

    // Head of the list
    Node head;
    Node left;

    public class Node {
        public char data;
        public Node next;

        // Linked list node
        public Node(char d) {
            data = d;
            next = null;
        }
    }

    // Initial parameters to this function are
    // &head and head
    boolean isPalindromeUtil(Node right) {
        left = head;

        // Stop recursion when right becomes null
        if (right == null)
            return true;

        // If sub-list is not palindrome then no need to
        // check for the current left and right, return
        // false
        boolean isp = isPalindromeUtil(right.next);
        if (isp == false)
            return false;

        // Check values at current left and right
        boolean isp1 = (right.data == left.data);

        left = left.next;

        // Move left to next node;
        return isp1;
    }

    // A wrapper over isPalindrome(Node head)
    boolean isPalindrome(Node head) {
        boolean result = isPalindromeUtil(head);
        return result;
    }

    // Push a node to linked list. Note that
    // this function changes the head
    public void push(char new_data) {

        // Allocate the node and put in the data
        Node new_node = new Node(new_data);

        // Link the old list off the the new one
        new_node.next = head;

        // Move the head to point to new node
        head = new_node;
    }

    // A utility function to print a
    // given linked list
    void printList(Node ptr) {
        while (ptr != null) {
            System.out.print(ptr.data + "->");
            ptr = ptr.next;
        }
        System.out.println("Null");
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 13;
        int[] ar = new int[n];
        ar[0] = 2;
        for (int i = 1; i < n; ++i) {
            ar[i] = ar[i - 1] * 2;
        }
        for (int i = 0; i < n; ++i) {
            int len = ar[i];
            Sol list = new Sol();
            for (int j = 0; j < len; ++j) {
                list.push('a');
            }
            long start = System.nanoTime();
            list.isPalindrome(list.head);
            long end = System.nanoTime();
            double time = (double) (end - start) / 1_000_000;
            System.out.println(time);
        }
    }
}

// This code is contributed by abhinavjain194
