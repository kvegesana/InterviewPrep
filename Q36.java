import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q36 ob = new Q36();
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(ob.checkSubarraySum(ar, k));
        in.close();
    }

    public boolean checkSubarraySum(int[] ar, int k) {
        int n = ar.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        if (n == 1)
            return false;
        // map.put(ar[0] % k, 0);
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            int el = ar[i];
            sum += el;
            int rem = sum % k;
            // System.out.println(rem);
            if (map.containsKey(rem)) {
                // System.out.println(rem + " " + el + " " + i);
                ArrayList<Integer> list = map.get(rem);
                if (list.size() > 1)
                    return true;
                else {
                    int idx = list.get(0);
                    if (idx != i - 1)
                        return true;
                    else {
                        list.add(i);
                        map.put(rem, list);
                    }
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(rem, list);
            }
        }
        if (map.containsKey(0)) {
            ArrayList<Integer> list = map.get(0);
            if (list.size() > 1)
                return true;
            else {
                int idx = list.get(0);
                if (idx > 0)
                    return true;
            }
        }
        return false;
    }

    // Version 2
    public boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (mp.containsKey(rem)) {
                if (i - mp.get(rem) > 1) {
                    return true;
                }
            } else {
                mp.put(rem, i);
            }
        }

        return false;
    }
}
