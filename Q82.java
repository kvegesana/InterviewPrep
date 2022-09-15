import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q82 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q82 ob = new Q82();
        List<Integer> ar = new ArrayList<>();
        // int n = in.nextInt();
        // for (int i = 0; i < n; ++i) {
        // ar.add(in.nextInt());
        // }
        // System.out.println(ob.makePowerNonDecreasing(ar));

        List<Integer> skill = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            skill.add(in.nextInt());
        }
        int k = in.nextInt();
        System.out.println(getSmallestInefficiencies(skill, k));
    }

    public long makePowerNonDecreasing(List<Integer> ar) {
        int n = ar.size();
        long res = 0;
        for (int i = 1; i < n; ++i) {
            if (ar.get(i) < ar.get(i - 1)) {
                res += (ar.get(i - 1) - ar.get(i));
            }
        }
        return res;
    }

    public static List<Integer> getSmallestInefficiencies(List<Integer> skill, int k) {
        int[] A = new int[skill.size()];
        for (int i = 0; i < skill.size(); ++i) {
            A[i] = skill.get(i);
        }
        Arrays.sort(A);
        int lo = 0, hi = (int) 1e8;
        while (lo < hi) { // find max bound
            int mid = (lo + hi + 1) >> 1;
            long cnt = 0;
            for (int i = 0, j = 0; i < A.length; i++) {
                while (A[i] - A[j] > mid) {
                    ++j;
                }
                cnt += i - j;
            }
            if (cnt <= k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < A.length && k > 0; i++) {
            while (A[i] - A[j] > lo) {
                ++j;
            }
            for (int s = j; s < i && k > 0; s++) {
                ans[--k] = A[i] - A[s];
            }
        }
        while (k > 0) {
            ans[--k] = lo + 1;
        }
        Arrays.sort(ans);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < ans.length; ++i) {
            res.add(ans[i]);
        }
        return res;
    }
}
