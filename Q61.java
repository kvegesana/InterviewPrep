public class Q61 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] ar) {
        int n = ar.length;
        int max = ar[0];
        int sum = ar[0];
        for (int i = 1; i < n; ++i) {
            sum = Math.max(ar[i], sum + ar[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
