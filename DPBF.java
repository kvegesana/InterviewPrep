import java.util.Arrays;
import java.util.Scanner;

/* A naive recursive implementation that simply follows
the above optimal substructure property */
class DPBF {
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int i, int j) {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between
        // first and last matrix, recursively calculate
        // count of multiplications for each parenthesis
        // placement and return the minimum count
        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(p, i, k)
                    + MatrixChainOrder(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];

            if (count < min)
                min = count;
        }

        // Return minimum count
        return min;
    }

    // Driver code
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int t = 1; t < p; t += 2) {
            int n = t;
            long start = System.nanoTime();
            int arr[] = new int[n];
            Arrays.fill(arr, 10);
            arr[0] = 1;
            int i;
            for (i = 1; i < n / 2; ++i) {
                arr[i] = arr[i - 1];
            }
            int k = 0;
            for (; i < n; ++i) {
                arr[i] = arr[k++];
            }
            // int arr[] = new int[] { 1, 2, 3, 4 };
            int size = arr.length;

            // System.out.println(
            // "Minimum number of multiplications is "
            // + MatrixChainOrder(arr, size));
            MatrixChainOrder(arr, 1, n - 1);
            long end = System.nanoTime();
            double time = (double) (end - start) / 1_000_000_000;
            System.out.println("Time: " + t + " " + time);
        }
    }
}
/* This code is contributed by Rajat Mishra */
