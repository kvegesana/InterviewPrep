public class Q77 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] ar) {
        int n = ar.length;
        int res = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (ar[i] < ar[i + 1]) {
                res += (ar[i + 1] - ar[i]);
            }
        }
        return res;
    }

    //
    public int maxProfit2(int[] ar) {
        int n = ar.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            if (min > ar[i]) {
                min = ar[i];
            } else if (ar[i] - min > max) {
                max = ar[i] - min;
            }
        }
        return max;
    }
}
