import java.util.Scanner;

public class Q65 {
    public static void main(String[] args) {
        Q65 ob = new Q65();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        System.out.println(ob.search(ar, 0));
        in.close();
    }

    public int search(int[] ar, int k) {
        int n = ar.length;
        int piv = pivot(ar);
        int ls = search(ar, 0, piv, k);
        int rs = search(ar, piv + 1, n - 1, k);
        // System.out.println(ls+" "+rs+" "+piv);
        if (ls != -1)
            return ls;
        if (rs != -1)
            return rs;
        return -1;
    }

    public int pivot(int[] ar) {
        int n = ar.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid > l && ar[mid] < ar[mid - 1]) {
                return mid - 1;
            } else if (mid < r && ar[mid] > ar[mid + 1]) {
                return mid;
            } else if (ar[l] >= ar[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int search(int[] ar, int l, int r, int k) {
        // System.out.println(l+" "+r);
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (ar[mid] == k)
                return mid;
            else if (ar[mid] > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
