public class Q51 {
    public static void main(String[] args) {

    }

    public int longestOnes(int[] ar, int k) {
        int l = 0, r = 0;
        int max = Integer.MIN_VALUE;
        int n = ar.length;
        int count = 0;
        while (r < n) {
            if (ar[r] == 0) {
                count++;
            }
            while (count == k + 1) {
                if (ar[l] == 0) {
                    count--;
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
