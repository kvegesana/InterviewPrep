import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        if (s == null)
            return 0;
        int n = s.length();
        if (n == 0)
            return 0;
        int l = 0;
        int r = 0;
        int max = 1;
        for (int i = 0; i < n; ++i) {
            // System.out.println(l + " Line " + r + " Character " + s.charAt(i));
            r = i;
            char c = s.charAt(i);
            int idx = (int) c;
            if (pos[idx] == -1) {
                r++;
                pos[idx] = i;
                max = Math.max(max, r - l);
            } else {
                // System.out.println("Hr" + i);
                if (pos[idx] >= l) {
                    l = pos[idx] + 1;
                } else {
                    r++;
                }
                pos[idx] = i;
                max = Math.max(max, r - l);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Q3 ob = new Q3();
        System.out.println(ob.lengthOfLongestSubstring(s));
    }
}
