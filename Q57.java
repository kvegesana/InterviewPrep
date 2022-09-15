import java.util.ArrayList;
import java.util.Scanner;

public class Q57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q57 ob = new Q57();
        int n = in.nextInt();
        int[][] graph = new int[n][n];
        // for(int i=0;i<)
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; ++i) {
            int len = isConnected[i].length;
            for (int j = 0; j < len; ++j) {
                if (i == j || isConnected[i][j] == 0) {
                    continue;
                } else {
                    int pari = findParent(parent, i);
                    int parj = findParent(parent, j);
                    if (pari != parj) {
                        parent[parj] = pari;
                    }

                }
            }

        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            // System.out.println(i+" "+parent[i]);
            if (parent[i] == i)
                res++;
        }
        return res;
    }

    public int findParent(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        else {
            // parent[i] = i;
            return findParent(parent, parent[i]);
        }
    }
}
