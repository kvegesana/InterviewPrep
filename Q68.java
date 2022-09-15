import java.util.Scanner;

public class Q68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        Q68 ob = new Q68();
        System.out.println(ob.jump(ar));
        in.close();
    }

    public int jump(int[] ar) {
        int n = ar.length;
        int jump = 0;
        int curEnd = 0;
        int far = 0;
        for (int i = 0; i < n; ++i) {
            far = Math.max(far, ar[i] + i);
            if (i == curEnd) {
                jump++;
                curEnd = far;
            }
        }
        return jump;
    }
}
