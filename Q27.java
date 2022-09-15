import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q27 ob = new Q27();
        int n = in.nextInt();
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; ++i) {
            ar[i][0] = in.nextInt();
            ar[i][1] = in.nextInt();
        }
        ob.merge(ar);
        in.close();
    }

    public int[][] merge(int[][] ar) {
        int n = ar.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new Pair(ar[i][0], ar[i][1]);
        }
        Arrays.sort(pairs);
        for (int i = 0; i < pairs.length; ++i) {
            System.out.println(pairs[i].a + " " + pairs[i].b);
        }
        ArrayList<Pair> list = new ArrayList<>();
        list.add(pairs[0]);
        for (int i = 1; i < n; ++i) {
            Pair prev = list.get(list.size() - 1);
            Pair curr = pairs[i];
            if (prev.b >= curr.a) {
                list.remove(list.size() - 1);
                Pair p = new Pair(Math.min(prev.a, curr.a), Math.max(prev.b, curr.b));
                list.add(p);
            } else {
                list.add(curr);
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            Pair p = list.get(i);
            System.out.println(p.a + " " + p.b);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; ++i) {
            res[i][0] = list.get(i).a;
            res[i][1] = list.get(i).b;
        }
        return res;
    }

    class Pair implements Comparable<Pair> {
        int a;
        int b;

        Pair(int l, int r) {
            a = l;
            b = r;
        }

        @Override
        public int compareTo(Pair o) {
            System.out.println(this.a + " " + this.b + " " + o.a + " " + o.b);
            // TODO Auto-generated method stub
            if (this.a == o.a && this.b == o.b)
                return 0;
            else if (this.a > o.a) {
                return 1;
            } else if (this.a < o.a)
                return -1;
            return 0;
        }

    }

}
