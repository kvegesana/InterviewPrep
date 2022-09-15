import java.util.Scanner;

public class Q4 {
    public String longestPalindrome(String s) {
        if (s == null)
            return s;
        if (s.length() <= 1)
            return s;
        int n = s.length();
        // Odd
        int res = 1;
        StringBuilder sb = new StringBuilder(s.charAt(0) + "");
        for (int i = 0; i < n; ++i) {

            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (res < r - l + 1) {
                        sb = new StringBuilder(s.substring(l, r + 1));
                    }
                    res = Math.max(res, r - l + 1);
                    l--;
                    r++;
                } else {
                    break;
                }
            }

        }

        // Even
        for (int i = 0; i < n; ++i) {

            int l = i;
            int r = i + 1;
            // System.out.println(l + " " + r);
            while (l >= 0 && r < n) {
                if (s.charAt(l) == s.charAt(r)) {
                    // res = Math.max(res, r - l + 1);
                    if (res < r - l + 1) {
                        sb = new StringBuilder(s.substring(l, r + 1));
                    }
                    res = Math.max(res, r - l + 1);
                    l--;
                    r++;
                } else {
                    break;
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q4 ob = new Q4();
        String s = in.nextLine();
        System.out.println(ob.longestPalindrome(s));
    }
}
