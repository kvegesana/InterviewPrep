import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q7 ob = new Q7();
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] ar = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ar[i][j] = in.nextInt();
            }
        }
        int x = in.nextInt();
        System.out.println(ob.matSearch(ar, m, n, x));
    }

    public int matSearch(int ar[][], int m, int n, int X) {
        // your code here
        // int idx = 0;
        int low = 0;
        int high = m - 1;
        int k = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            if (ar[mid][n - 1] == X)
                return 1;
            else if (ar[mid][n - 1] > X) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Hello " + k);
        low = 0;
        high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            if (ar[k][mid] == X)
                return 1;
            else if (ar[k][mid] > X) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

}
