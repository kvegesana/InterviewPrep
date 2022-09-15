import java.util.Arrays;

public class Q47 {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] ar, int k) {
        Arrays.sort(ar);
        int n = ar.length;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; ++i) {
            int val = ar[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = val + ar[l] + ar[r];
                if (Math.abs(sum - k) < min) {
                    min = Math.abs(sum - k);
                    ans = sum;
                }
                if (sum < k) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
