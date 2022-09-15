import java.util.HashMap;
import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q11 ob = new Q11();
        String s = in.nextLine();
        System.out.println(ob.romanToInt(s));
    }

    public int romanToInt(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        res += map.get(s.charAt(0));
        for (int i = 1; i < n; ++i) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);
            if (map.get(prev) < map.get(curr)) {
                res -= map.get(prev);
                res -= map.get(prev);
                res += map.get(curr);
            } else {
                res += map.get(curr);
            }
            // System.out.println(res);
        }
        return res;
    }
}
