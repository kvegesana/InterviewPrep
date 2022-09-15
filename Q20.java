import java.util.Arrays;

public class Q20 {
    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            int idx = i;
            pair[i] = new Pair(dist, idx);
        }
        Arrays.sort(pair);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; ++i) {
            int idx = pair[i].idx;
            res[i][0] = points[idx][0];
            res[i][1] = points[idx][1];
        }
        return res;
    }

    class Pair implements Comparable<Pair> {
        int dist;
        int idx;

        Pair(int a, int b) {
            dist = a;
            idx = b;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return o.dist - this.dist;
        }

    }
}
