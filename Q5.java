import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        Q5 ob = new Q5();
        // System.out.println(Integer.MAX_VALUE);
        System.out.println(ob.reverse(x));
    }

    public int reverse(int x) {
        int res = 0;
        boolean neg = false;
        if (x < 0)
            neg = true;
        x = Math.abs(x);
        while (x > 0) {
            int temp = res;
            int rem = x % 10;
            temp = temp * 10 + rem;
            int newtemp = temp / 10;
            if (newtemp != res)
                return 0;
            x /= 10;
            res = temp;
        }

        return !neg ? res : -res;
    }
}
