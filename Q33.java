import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        Q33 ob = new Q33();
        ob.nextPermutation(ar);
        in.close();
    }

    public void nextPermutation(int[] ar) {
        int n = ar.length;
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            int a = ar[i];
            int b = ar[i + 1];
            if (a < b) {
                idx = i;
                break;
            }
        }
        System.out.println(idx);
        if (idx == -1) {
            int[] br = new int[n];
            idx = 0;
            for (int i = n - 1; i >= 0; i--) {
                br[idx++] = ar[i];
            }
            for (int i = 0; i < n; ++i) {
                ar[i] = br[i];
            }
            return;
        }
        int idx2 = idx + 1;
        for (int i = idx + 1; i < n; ++i) {
            int el = ar[i];
            if (el > ar[idx]) {
                if (ar[idx2] > el) {
                    idx2 = i;
                }
            }
        }
        // System.out.println(idx2);
        int temp = ar[idx];
        ar[idx] = ar[idx2];
        ar[idx2] = temp;
        temp = idx + 1;
        // System.out.println(idx + " Hello ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = idx + 1; i < n; ++i) {
            list.add(ar[i]);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); ++i) {
            ar[temp++] = list.get(i);
        }
        // for (int i = 0; i < n; ++i) {
        // System.out.println(ar[i]);
        // }
    }
}
