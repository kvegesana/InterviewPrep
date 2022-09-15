public class Q78 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] ar) {
        int n = ar.length;
        int s0 = 0;
        int s1 = Integer.MIN_VALUE, s2 = Integer.MIN_VALUE, s3 = Integer.MIN_VALUE, s4 = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            s1 = Math.max(s1, s0 - ar[i]);
            s2 = Math.max(s2, s1 + ar[i]);
            s3 = Math.max(s3, s2 - ar[i]);
            s4 = Math.max(s4, s3 + ar[i]);
        }
        return s4;
    }
}
