import java.util.ArrayList;

public class Q22 {
    public static void main(String[] args) {

    }

    public int[] findBuildings(int[] ar) {
        int n = ar.length;
        ArrayList<Integer> res = new ArrayList<>();
        int rmax = ar[n - 1];
        res.add(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (rmax < ar[i]) {
                res.add(i);
                rmax = ar[i];
            }
        }
        int[] out = new int[res.size()];
        int j = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            out[j++] = res.get(i);
        }
        return out;
    }
}
