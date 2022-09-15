import java.util.LinkedList;
import java.util.Queue;

public class Q63 {
    public static void main(String[] args) {

    }

    class Solution {
        public int orangesRotting(int[][] grid) {
            int[] x = new int[] { 1, -1, 0, 0 };
            int[] y = new int[] { 0, 0, -1, 1 };
            Queue<Integer> qx = new LinkedList<>();
            Queue<Integer> qy = new LinkedList<>();
            int m = grid.length;
            int n = grid[0].length;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 2) {
                        qx.add(i);
                        qy.add(j);
                    }
                }
            }
            int ans = 0;
            while (!qx.isEmpty()) {
                int size = qx.size();
                for (int j = 0; j < size; ++j) {
                    int xi = qx.poll();
                    int yi = qy.poll();
                    for (int i = 0; i < 4; ++i) {
                        int xnew = xi + x[i];
                        int ynew = yi + y[i];
                        if (xnew < m && ynew < n && xnew > -1 && ynew > -1 && grid[xnew][ynew] == 1) {
                            grid[xnew][ynew] = 2;
                            qx.add(xnew);
                            qy.add(ynew);
                        }
                    }
                }
                ans++;
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 2)
                        return ans - 1;
                }
            }
            return 0;
        }
    }
}
