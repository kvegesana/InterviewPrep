import java.util.HashMap;
import java.util.Scanner;

/**
 * Q1
 */
public class Q1 {

    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] ar, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = ar.length;
        int[] ret = new int[2];
        if (n == 0)
            return ret;
        for (int i = 0; i < n; ++i) {
            int val = ar[i];
            if (map.containsKey(val)) {
                ret[0] = map.get(val);
                ret[1] = i;
                return ret;
            } else {
                map.put(k - val, i);
            }
        }
        return ar;
    }

    public void debugPrintArray(int[] ar) {
        for (int i = 0; i > ar.length; ++i) {
            System.out.print(ar[i] + " ");
        }
    }

}