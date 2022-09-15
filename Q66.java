import java.util.PriorityQueue;

public class Q66 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] ar, int k) {
        int n = ar.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; ++i) {
            pq.add(ar[i]);
        }
        long ans = 0;
        while (k > 0) {
            int pop = pq.poll();
            int sec = pq.isEmpty() ? 0 : pq.poll();
            if (pop > sec && k > (pop - sec)) {
                k -= (pop - sec);
                int len = pop - sec;
                int sum = sec + 1 + pop;
                sum *= len;
                sum /= 2;
                ans += sum;
                pq.add(sec);
                pq.add(sec);
            } else if (pop == sec) {
                k--;
                ans += pop;
                pop--;
                pq.add(sec);
                pq.add(pop);
            } else if (k < pop - sec) {
                int a = pop - k;
                int sum = a + pop;
                sum *= k;
                sum /= 2;
                ans += sum;
                k = 0;
            }
        }
        int mod = 1000000007;
        return (int) (ans % mod);
    }
}
