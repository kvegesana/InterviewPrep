import java.util.ArrayList;
import java.util.Random;

// Java program to print all permutations of a 
// given string. 
public class Comb {
    static Integer count;
    static ArrayList<String> list;

    public static void main(String[] args) {
        String str = "890ab1234567";
        int n = str.length();
        Comb permutation = new Comb();
        int bound = 10000000;
        count = bound;
        list = new ArrayList<>();
        permute(str, 0, n - 1);
        int len = (int) Math.floor(n / Math.E);

        // System.out.println(list.get(0));
        Random r = new Random();
        int resCount = 0;

        for (int i = 0; i < bound; i++) {
            int idx = r.nextInt(bound);
            String s = list.get(idx);
            char[] ar = s.toCharArray();
            char ch = ar[0];
            for (int j = 0; j < len; ++j) {
                if (ch < ar[j]) {
                    ch = ar[j];
                }
            }
            for (int j = len; j < s.length(); ++j) {
                if (ch < ar[j]) {
                    if (ar[j] == 'a') {
                        resCount++;
                        // System.out.println(s);
                    }
                    break;
                }
            }
        }
        double pro = (double) resCount / bound;
        System.out.println("Count:" + pro + " " + resCount);
    }

    /**
     * permutation function
     * 
     * @param str string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    private static void permute(String str, int l, int r) {
        if (count > 0) {
            if (l == r) {
                // System.out.println(str);
                list.add(str);
                count--;
            } else {
                for (int i = l; i <= r; i++) {
                    str = swap(str, l, i);
                    permute(str, l + 1, r);
                    str = swap(str, l, i);
                }
            }
        }
    }

    /**
     * Swap Characters at position
     * 
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}

// This code is contributed by Mihir Joshi
