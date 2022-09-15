public class Q67 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] ar) {
        int n = ar.length;
        int var = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ar[i] + i >= var) {
                var = i;
            }
        }
        return var == 0 ? true : false;
    }
}
