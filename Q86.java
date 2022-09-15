import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Q86 {
    public static void main(String[] args) {

    }

    public String reorganizeString(String s) {
        int n = s.length();
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> b.b - a.b);
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < n; ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Entry entry : map.entrySet()) {
            char c = (Character) entry.getKey();
            int count = (Integer) entry.getValue();
            if (count > n / 2)
                return "";
            Node node = new Node(c, count);
            q.offer(node);
        }
        StringBuilder sb = new StringBuilder();
        Node top = q.poll();
        sb.append(top.a);
        top.b--;
        for (int i = 1; i < n; ++i) {
            Node node = q.poll();
            sb.append(node.a);
            q.offer(top);
            top = node;
            top.b--;
        }
        return sb.toString();
    }

    class Node {
        public char a;
        public int b;

        Node(char a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
