import java.util.ArrayList;
import java.util.Scanner;

public class Q32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        Q32 ob = new Q32();
        int[] br = ob.sortedSquares(ar);
        for (int i = 0; i < br.length; ++i) {
            System.out.println(br[i]);
        }
    }

    public int[] sortedSquares(int[] ar) {
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        int n = ar.length;
        for (int i = 0; i < n; ++i) {
            if (ar[i] < 0) {
                int a = ar[i] * ar[i];
                neg.add(a);
            } else {
                int a = ar[i] * ar[i];
                pos.add(a);
            }
        }
        int l = 0;
        int r = neg.size() - 1;
        ArrayList<Integer> neg2 = new ArrayList<>();
        while (r >= 0) {
            int a = neg.get(r);
            neg2.add(a);
            r--;
        }
        neg = new ArrayList<>();

        l = 0;
        r = 0;
        int k = 0;
        while (l < neg2.size() && r < pos.size()) {
            int a = neg2.get(l);
            int b = pos.get(r);
            if (a < b) {
                ar[k++] = a;
                l++;
            } else {
                ar[k++] = b;
                r++;
            }
        }
        while (l < neg2.size()) {
            ar[k++] = neg2.get(l++);
        }
        while (r < pos.size()) {
            ar[k++] = pos.get(r++);
        }
        return ar;
    }
}
