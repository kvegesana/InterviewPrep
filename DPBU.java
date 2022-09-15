import java.util.Arrays;
import java.util.Scanner;

// Dynamic Programming Java implementation of Matrix
// Chain Multiplication.
// See the Cormen book for details of the following
// algorithm
class DPBU {

    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static long MatrixChainOrder(int p[], int n) {
        /*
         * For simplicity of the
         * program, one extra row and
         * one extra column are allocated in m[][]. 0th row
         * and 0th column of m[][] are not used
         */
        long m[][] = new long[n][n];
        if (n == 1)
            return 1;

        int i, j, k, L;
        long q;

        /*
         * m[i, j] = Minimum number of scalar
         * multiplications needed to compute the matrix
         * A[i]A[i+1]...A[j] = A[i..j] where
         * dimension of A[i] is p[i-1] x p[i]
         */

        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Long.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j]
                            + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }

    // Driver code
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for (int t = 1; t < p; t *= 2) {
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
            MatrixChainOrder(arr, size);
            long end = System.nanoTime();
            double time = (double) (end - start) / 1_000_000_000;
            System.out.println("Time: " + t + " " + time);
        }
    }
}
/* This code is contributed by Rajat Mishra */
