public class Q17 {
    public static void main(String[] args) {

    }

    static int majorityElement(int ar[], int n) {
        // your code here
        int count = 1;
        if (n == 1)
            return ar[0];
        int el = ar[0];
        for (int i = 1; i < n; ++i) {
            if (ar[i] == el) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    el = ar[i];
                    count = 1;
                }
            }
        }
        int maxcount = 0;
        for (int i = 0; i < n; ++i) {
            if (ar[i] == el)
                maxcount++;
        }
        if (maxcount > n / 2)
            return el;
        return -1;
    }
}
