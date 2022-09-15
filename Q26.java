import java.util.Scanner;

public class Q26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q26 ob = new Q26();
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        int[] res = ob.productExceptSelf(ar);
        for (int i = 0; i < n; ++i) {
            System.out.println(res[i]);
        }
    }

    public int[] productExceptSelf(int[] ar) {
        int n = ar.length;
        int[] l = new int[n];
        // int[] r = new int[n];
        l[0] = 1;
        for (int i = 1; i < n; ++i) {
            l[i] = l[i - 1] * ar[i - 1];
        }
        // r[n - 1] = 1;
        int ra = 1;
        for (int i = n - 1; i >= 0; i--) {
            l[i] *= ra;
            ra *= ar[i];
        }
        return l;
        // for (int i = 0; i < n; ++i) {

        // ar[i] = l[i];
        // System.out.println(ar[i] + " " + l[i] + " " + r[i]);
        // }
        // System.out.println("Hello");
        // return ar;
    }
}
