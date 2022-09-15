import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q13 ob = new Q13();
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        List<List<Integer>> list = ob.threeSum(ar);
        for (int i = 0; i < list.size(); ++i) {
            List<Integer> l = list.get(i);
            for (int j = 0; j < l.size(); ++j) {
                System.out.print(l.get(j) + " ");
            }
            System.out.println();
        }
        in.close();
    }

    public List<List<Integer>> threeSum(int[] ar) {
        int n = ar.length;
        Arrays.sort(ar);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n == 0)
            return list;
        for (int i = 0; i < n - 2 && ar[i] <= 0; ++i) {
            if (i == 0 || ar[i - 1] != ar[i]) {
                int val = ar[i];
                int l = i + 1;
                int r = n - 1;
                while (l < r) {
                    if (val + ar[l] + ar[r] == 0) {
                        List<Integer> arr = new ArrayList<Integer>();
                        arr.add(val);
                        arr.add(ar[l]);
                        arr.add(ar[r]);
                        list.add(arr);
                        l++;
                        r--;
                        while (l < r && ar[l] == ar[l - 1])
                            l++;
                    } else if (val + ar[l] + ar[r] > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return list;
    }
}
