import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        Q45 ob = new Q45();
        List<List<Integer>> l = ob.subsets(ar);
        System.out.println(l.size() + " Size");
        in.close();
    }

    // public List<List<Integer>> list;

    public List<List<Integer>> subsets(int[] ar) {
        int n = ar.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (n == 0)
            return list;
        backtrack(ar, 0, ar.length, new ArrayList<>(), list);
        return list;
    }

    public void backtrack(int[] ar, int start, int end, ArrayList<Integer> arr, List<List<Integer>> list) {
        if (start == end) {
            list.add(new ArrayList<Integer>(arr));
            return;
        }
        arr.add(ar[start]);
        backtrack(ar, start + 1, end, arr, list);
        arr.remove(arr.size() - 1);
        backtrack(ar, start + 1, end, arr, list);
        return;
    }
}
