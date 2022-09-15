public class Q8 {
    public static void main(String[] args) {

    }

    // Version 1
    public boolean searchMatrix(int[][] ar, int k) {
        int m = ar.length;
        int n = ar[0].length;
        int low = 0;
        int high = n - 1;
        while (low < m && high >= 0) {
            int val = ar[low][high];
            System.out.println(val);
            if (val == k)
                return true;
            else if (val > k)
                high--;
            else
                low++;
        }
        return false;
    }

}
