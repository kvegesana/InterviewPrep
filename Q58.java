import java.util.Arrays;
import java.util.Comparator;

public class Q58 {
    public static void main(String[] args) {

    }

    public int maximumUnits(int[][] ar, int truckSize) {
        int n = ar.length;
        Pair[] br = new Pair[n];
        for (int i = 0; i < n; ++i) {
            br[i] = new Pair(ar[i][0], ar[i][1]);
        }
        Arrays.sort(br);

        int ans = 0;
        int i = 0;
        while (i < n && truckSize > 0) {
            int units = br[i].b;
            int num = br[i].a;
            if (truckSize - num >= 0) {
                ans += (num * units);
                truckSize -= num;
            } else {
                ans += (units * (truckSize));
                truckSize = 0;
            }

            i++;
            // System.out.println(ans+" "+truckSize+" "+i);
        }
        return ans;
    }

    class Pair implements Comparable<Pair> {
        int a;
        int b;

        Pair(int num, int units) {
            a = num;
            b = units;
        }

        @Override
        public int compareTo(Pair o) {
            // TODO Auto-generated method stub
            return -this.b + o.b;
        }

    }
}
