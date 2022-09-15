public class Q74 {
    public static void main(String[] args) {

    }

    public void rotate(int[][] ar) {
        int n = ar.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - i - 1; ++j) {
                int temp = ar[i][j];
                ar[i][j] = ar[n - j - 1][i];
                ar[n - j - 1][i] = ar[n - i - 1][n - j - 1];
                ar[n - i - 1][n - j - 1] = ar[j][n - i - 1];
                ar[j][n - i - 1] = temp;
            }
        }
        return;
    }
}
