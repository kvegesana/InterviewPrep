import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Q81 {
    public int findNumWaysToSplit(String cat, int k) {
        HashMap<Character, Integer> pref = new HashMap<>();
        HashMap<Character, Integer> suff = new HashMap<>();
        int n = cat.length();
        for (int i = 0; i < n; ++i) {
            char c = cat.charAt(i);
            suff.put(c, suff.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            char c = cat.charAt(i);
            suff.put(c, suff.getOrDefault(c, 0) - 1);
            if (suff.get(c) == 0) {
                suff.remove(c);
            }
            pref.put(c, pref.getOrDefault(c, 0) + 1);
            char temp = 'a';
            int po = 0;
            for (int j = 0; j < 26; ++j) {
                char ch = (char) (temp + j);
                if (pref.containsKey(ch) && suff.containsKey(ch)) {
                    po++;
                }
            }
            if (po > k) {
                // System.out.println(i);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();
        Q81 ob = new Q81();
        System.out.println(ob.findNumWaysToSplit(s, n));
        in.close();
    }
}
