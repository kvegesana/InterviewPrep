public class Q56 {
    public static void main(String[] args) {

    }

    public boolean isRobotBounded(String s) {
        int n = s.length();
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int idx = 0;
        int x = 0, y = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == 'G') {
                x += dir[idx][0];
                y += dir[idx][1];
            } else if (c == 'L') {
                idx = (idx + 3) % 4;
            } else {
                idx = (idx + 1) % 4;
            }
        }
        if (x == 0 && y == 0)
            return true;
        if (idx != 0)
            return true;
        return false;
    }

}
