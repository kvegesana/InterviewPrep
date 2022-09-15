import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q52 {
    public static void main(String[] args) {

    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        int m = firstList.length;
        int n = secondList.length;
        while (i < m && j < n) {
            int l = Math.max(firstList[i][0], secondList[j][0]);
            int r = Math.min(firstList[i][1], secondList[j][1]);
            if (l <= r) {
                list.add(new int[] { l, r });
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
