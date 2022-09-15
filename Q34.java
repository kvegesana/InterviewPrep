import java.util.List;

public class Q34 {
    public static void main(String[] args) {

    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dm = binaryMatrix.dimensions();
        int r = dm.get(0);
        int c = dm.get(1);
        int res = 101;

        int l = 0;
        int m = c - 1;
        while (l < r && m >= 0) {
            int el = binaryMatrix.get(l, m);
            // System.out.println(el+" " + l+" "+m);
            if (el == 0) {
                l++;
            } else {
                res = Math.min(res, m);
                m--;
            }
        }
        return res == 101 ? -1 : res;
    }
}

interface BinaryMatrix {
    public default int get(int row, int col) {
        return col;
    }

    public default List<Integer> dimensions() {
        return null;
    }
};