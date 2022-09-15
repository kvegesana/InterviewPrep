import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q6 ob = new Q6();
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        System.out.println(ob.longestSumContigousSubarray(ar));
    }

    public int longestSumContigousSubarray(int[] ar) {
        int n = ar.length;
        int max = ar[0];
        int sum = ar[0];
        for (int i = 1; i < n; ++i) {
            sum = Math.max(ar[i], ar[i] + sum);
            max = Math.max(sum, max);
        }
        return max;
    }
}
