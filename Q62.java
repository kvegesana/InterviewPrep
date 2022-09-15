import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Q62 {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        int n = numCourses;
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            g.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!vis[i]) {
                System.out.println(i);
                if (dfs(g, i, vis) == false) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean dfs(ArrayList<ArrayList<Integer>> g, int k, boolean[] vis) {
        vis[k] = true;
        Integer i;
        Iterator<Integer> it = g.get(k).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!vis[i]) {
                return dfs(g, i, vis);
            } else {
                return false;
            }
        }
        return true;
    }
}
