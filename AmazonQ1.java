import java.util.Scanner;

public class AmazonQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        AmazonQ1 ob = new AmazonQ1();
        System.out.println(ob.findMaxProducts(ar));
    }

    public int findMaxProducts(int[] ar) {
        int n = ar.length;
        if (n == 1)
            return ar[0];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int prev = ar[i];
            int sum = prev;
            for (int j = i - 1; j >= 0; j--) {
                if (ar[j] < prev) {
                    sum += ar[j];
                    prev = ar[j];
                } else {
                    sum += (prev - 1);
                    prev = prev - 1;
                }
                if (prev == 0)
                    break;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
