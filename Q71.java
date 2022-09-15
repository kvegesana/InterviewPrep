import java.util.LinkedList;
import java.util.Queue;

public class Q71 {
    public static void main(String[] args) {

    }

    public int getFood(char[][] ar) {
        int m = ar.length;
        int n = ar[0].length;
        int[] x = new int[] { -1, 1, 0, 0 };
        int[] y = new int[] { 0, 0, -1, 1 };
        int xs = -1;
        int ys = -1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (ar[i][j] == '*') {
                    xs = i;
                    ys = j;
                    break;
                }
            }
        }
        boolean reach = false;
        Queue<Pair> q = new LinkedList<Pair>();
        boolean[][] vis = new boolean[m][n];
        q.add(new Pair(xs, ys));
        int ans = 0;
        vis[xs][ys] = true;
        while (!q.isEmpty() && !reach) {
            int size = q.size();
            while (size-- > 0) {
                Pair point = q.poll();
                int a = point.a;
                int b = point.b;
                // vis[a][b] = true;
                for (int i = 0; i < 4; ++i) {
                    int xa = a + x[i];
                    int ya = b + y[i];
                    if (bounds(xa, ya, m, n)) {
                        if (ar[xa][ya] == '#') {
                            reach = true;
                            break;
                        } else if (ar[xa][ya] == 'O' && !vis[xa][ya]) {
                            q.add(new Pair(xa, ya));
                            vis[xa][ya] = true;
                        }
                    }
                }
            }
            if (reach)
                break;
            ans++;
        }
        return -1;
    }

    public boolean bounds(int xa, int ya, int m, int n) {
        if (xa >= 0 && xa < m && ya >= 0 && ya < n)
            return true;
        return false;
    }

    class Pair {
        int a;
        int b;

        Pair(int x, int y) {
            a = x;
            b = y;
        }
    }
}
