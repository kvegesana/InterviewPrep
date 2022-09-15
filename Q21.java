import java.util.HashMap;
import java.util.Scanner;

public class Q21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q21 ob = new Q21();
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(ob.subarraySum(ar, k));
        in.close();
    }

    public int subarraySum(int[] ar, int k) {
        int n = ar.length;
        int count = 0;
        int[] pref = new int[n];
        pref[0] = ar[0];
        for (int i = 1; i < n; ++i) {
            pref[i] = pref[i - 1] + ar[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(pref[i] - k)) {
                count += map.get(pref[i] - k);
            }
            map.put(pref[i], map.getOrDefault(pref[i], 0) + 1);
        }
        return count;
    }
}
