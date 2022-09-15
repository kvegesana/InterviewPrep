import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Skyline {
    public List<int[]> getSkyline(int[][] buildings) {
        return merge(buildings, 0, buildings.length - 1);
    }

    private LinkedList<int[]> merge(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> res = new LinkedList<>();
        // System.out.println(lo + " LH " + hi);
        if (lo > hi) {
            return res;
        } else if (lo == hi) {
            res.add(new int[] { buildings[lo][0], buildings[lo][2] });
            res.add(new int[] { buildings[lo][1], 0 });
            return res;
        }
        int mid = lo + (hi - lo) / 2;
        LinkedList<int[]> left = merge(buildings, lo, mid);
        LinkedList<int[]> right = merge(buildings, mid + 1, hi);
        int leftH = 0, rightH = 0;
        while (!left.isEmpty() || !right.isEmpty()) {
            long x1 = left.isEmpty() ? Long.MAX_VALUE : left.peekFirst()[0];
            long x2 = right.isEmpty() ? Long.MAX_VALUE : right.peekFirst()[0];
            // System.out.println(x1 + " " + x2);
            int x = 0;
            if (x1 < x2) {
                int[] temp = left.pollFirst();
                x = temp[0];
                leftH = temp[1];
            } else if (x1 > x2) {
                int[] temp = right.pollFirst();
                x = temp[0];
                rightH = temp[1];
            } else {
                x = left.peekFirst()[0];
                leftH = left.pollFirst()[1];
                rightH = right.pollFirst()[1];
            }
            int h = Math.max(leftH, rightH);
            // System.out.println(res.isEmpty() ? "Empty" : " x : " + x + " " +
            // res.peekLast()[1] + " H: " + h);
            if (res.isEmpty() || h != res.peekLast()[1]) {
                res.add(new int[] { x, h });
                // System.out.println(" X and H are : " + x + " " + h);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Skyline sk = new Skyline();
        int[][] p = new int[n][3];
        for (int i = 0; i < n; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            p[i][0] = a;
            p[i][2] = b;
            p[i][1] = c;
        }
        long start = System.nanoTime();
        List<int[]> list = sk.getSkyline(p);
        long end = System.nanoTime();
        int size = list.size();
        double time = (end - start) / 1_000_000;
        System.out.println(size + " " + time);
        // for (int i = 0; i < size; ++i) {
        // int[] ar = list.remove(0);
        // System.out.println(ar[0] + " " + ar[1]);
        // }
        in.close();
    }
}
