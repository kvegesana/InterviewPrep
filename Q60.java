import java.util.Arrays;

public class Q60 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxDA = 0;
        long maxDB = 0;
        int n = horizontalCuts.length;
        int m = verticalCuts.length;
        maxDA = Math.max(horizontalCuts[0], h - horizontalCuts[n - 1]);
        for (int i = 0; i < horizontalCuts.length - 1; ++i) {
            int a = horizontalCuts[i];
            int b = horizontalCuts[i + 1];
            maxDA = Math.max(maxDA, b - a);
        }
        maxDB = Math.max(verticalCuts[0], w - verticalCuts[m - 1]);
        for (int i = 0; i < verticalCuts.length - 1; ++i) {
            int a = verticalCuts[i];
            int b = verticalCuts[i + 1];
            maxDB = Math.max(maxDB, b - a);
        }
        if (horizontalCuts.length == 1) {

        }
        if (verticalCuts.length == 1) {

        }
        // System.out.println(maxDA + " "+maxDB);
        int mod = 1000000007;
        long res = (maxDA % mod * maxDB % mod) % mod;

        return (int) res;
    }

    public static void main(String[] args) {

    }
}
