import java.util.PriorityQueue;

public class Q59 {
    public static void main(String[] args) {

    }

    public int connectSticks(int[] ar) {
        int n = ar.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            pq.add(ar[i]);
        }
        int res = 0;
        if (n == 1)
            return 0;
        while (pq.size() != 1) {
            int min1 = pq.poll();
            int min2 = pq.poll();
            int min = min1 + min2;
            res += (min);
            pq.add(min);
        }
        return res;
    }
}
