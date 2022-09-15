import java.util.Arrays;

public class Q55 {
    public static void main(String[] args) {

    }

    public int minMeetingRooms(int[][] intervals) {
        int n = ar.length;
        int[] ar = new int[n];
        int[] br = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = intervals[i][0];
            br[i] = intervals[i][1];
        }
        Arrays.sort(ar);
        Arrays.sort(br);
        int ans = 0;
        int i = 0, j = 0;
        while (i < n) {
            if (ar[i] < br[j]) {
                ans++;
                i++;
            } else {
                ans--;
                j++;
            }
        }
        return ans;
    }
}
