import java.util.Arrays;
import java.util.Scanner;

public class Q75 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Q75 ob = new Q75();
        System.out.println(ob.firstUniqChar(s));
        in.close();
    }

    public int firstUniqChar(String s) {
        int n = s.length();
        int[] dp = new int[26];
        Arrays.fill(dp, -2);
        for (int i = 0; i < n; ++i) {
            int ch = s.charAt(i) - 'a';
            // System.out.println(ch);
            if (dp[ch] == -2) {
                dp[ch] = i;
            } else if (dp[ch] != -2) {
                dp[ch] = Integer.MAX_VALUE;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; ++i) {
            if (dp[i] != -2) {
                res = Math.min(res, dp[i]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
