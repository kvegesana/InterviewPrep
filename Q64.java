import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Q64 {
    public static void main(String[] args) {

    }

    public int findLeastNumOfUniqueInts(int[] ar, int k) {
        int n = ar.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(ar[i])) {
                map.put(ar[i], 0);
            }
            map.put(ar[i], map.get(ar[i]) + 1);
        }
        Pair[] pair = new Pair[map.size()];
        int i = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            pair[i++] = new Pair(entry.getKey(), entry.getValue());
        }
        Arrays.sort(pair);
        for (i = 0; i < pair.length; ++i) {
            if (k >= pair[i].b) {
                k -= pair[i].b;
            } else {
                break;
            }
        }
        return pair.length - i;
    }

    class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int key, int val) {
            a = key;
            b = val;
        }

        @Override
        public int compareTo(Q64.Pair o) {
            // TODO Auto-generated method stub
            return this.b - o.b;
        }

    }
}
