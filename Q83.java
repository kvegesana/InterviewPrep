import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The Main class implements an application that reads lines from the standard
 * input
 * and prints them to the standard output.
 */
public class Q83 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int k = 0;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, ArrayList<String>> cost = new HashMap<>();
        StringBuilder se;
        se = new StringBuilder();
        while ((line = in.readLine()) != null) {
            if (line.contains(";")) {
                String[] edges = line.split(";");
                for (int i = 0; i < edges.length; ++i) {
                    String[] op = edges[i].split(",");
                    String one = op[0];
                    String two = op[1];
                    if (!map.containsKey(one)) {
                        map.put(one, k++);
                    }
                    if (!map.containsKey(two)) {
                        map.put(two, k++);
                    }
                    double cr = Double.parseDouble(op[2]);
                    double revrate = 1.0 / cr;
                    if (!cost.containsKey(one)) {
                        cost.put(one, new ArrayList<>());
                    }
                    if (!cost.containsKey(two)) {
                        cost.put(two, new ArrayList<>());
                    }
                    ArrayList<String> oneList = cost.get(one);
                    ArrayList<String> twoList = cost.get(two);
                    StringBuilder sb1 = new StringBuilder(two + " " + cr);
                    oneList.add(sb1.toString());
                    StringBuilder sb2 = new StringBuilder(one + " " + revrate);
                    twoList.add(sb2.toString());
                    cost.put(one, oneList);
                    cost.put(two, twoList);
                }
            } else {
                se.append(line + " ");
            }
        }
        String start = se.toString().split(" ")[0];
        String end = se.toString().split(" ")[1];
        System.out.println(start + " " + end);
        int size = cost.size();
        boolean[] vis = new boolean[size + 1];
        Arrays.fill(vis, false);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        double res = -1.0;
        while (!q.isEmpty()) {
            String node = q.poll();
            vis[map.get(node)] = true;
            ArrayList<String> list = cost.get(node);
            for (int i = 0; i < list.size(); ++i) {
                String mad = list.get(i);
                String[] spl = mad.split(" ");
                String to = spl[0];
                // double cost =
            }
        }
    }
}
