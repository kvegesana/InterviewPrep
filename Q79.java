import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q79 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q79 ob = new Q79();
        System.out.println(ob.getCombinations(in.nextInt()).size());
        in.close();
    }

    public List<List<Integer>> getCombinations(int n) {
        if (n == 0)
            return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        printComb(res, new ArrayList<>(), n);
        System.out.println(res.size());
        return res;
    }

    public void printComb(List<List<Integer>> res, List<Integer> list, int n) {
        if (n == 0) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            list.add(i);
            printComb(res, list, n - i);
            list.remove(i);
        }
    }
}
