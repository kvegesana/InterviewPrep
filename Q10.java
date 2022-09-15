public class Q10 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] ar) {
        int n = ar.length;
        int max = 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int area = Math.min(ar[l], ar[r]) * (r - l);
            if (ar[r] < ar[l]) {
                r--;
            } else {
                l++;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}
