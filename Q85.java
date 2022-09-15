public class Q85 {
    public int majorityElement(int[] ar) {
        int n = ar.length;
        int count = 1;
        int el = ar[0];
        for (int i = 1; i < n; ++i) {
            if (el == ar[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    el = ar[i];
                    count = 1;
                }
            }
        }
        return el;
    }
}
