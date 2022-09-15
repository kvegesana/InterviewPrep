
// Java program using memoization
import java.io.*;
import java.util.*;

class DPTD {

    static long[][] dp = new long[5000][5000];

    // Function for matrix chain multiplication
    static long matrixChainMemoised(int[] p, int i, int j) {
        // System.out.println(i + " " + j);
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(
                    dp[i][j], matrixChainMemoised(p, i, k)
                            + matrixChainMemoised(p, k + 1, j)
                            + p[i - 1] * p[k] * p[j]);
        }
        return dp[i][j];
    }

    static long MatrixChainOrder(int[] p, int n) {
        int i = 1, j = n - 1;
        return matrixChainMemoised(p, i, j);
    }

    // Driver Code
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int p = in.nextInt();
        // for (int t = 1; t < p; t *= 2) {
        // long start = System.nanoTime();
        // int len = t;

        // int arr[] = new int[len];
        // Arrays.fill(arr, 10);
        // arr[0] = 1;
        // int i;
        // for (i = 1; i < len / 2; ++i) {
        // arr[i] = arr[i - 1] + 1;
        // }
        // int k = 0;
        // for (; i < len; ++i) {
        // arr[i] = arr[k++];
        // }
        // int n = arr.length;
        // // for (i = 0; i < n; ++i) {
        // // System.out.println(arr[i]);
        // // }

        // for (long[] row : dp)
        // Arrays.fill(row, -1);

        // // System.out.println("Minimum number of multiplications is " +
        // MatrixChainOrder(arr, n);
        // long end = System.nanoTime();
        // double time = (double) (end - start) / 1_000_000_000;
        // System.out.println("Time: " + i + " " + time);
        // }
        int[] ar = { 40, 20, 30, 10, 30 };
        int n = ar.length;
        for (long[] row : dp)
            Arrays.fill(row, 0);
        System.out.println(MatrixChainOrder(ar, n));
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; ++j) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// This code is contributed by avanitrachhadiya2155
