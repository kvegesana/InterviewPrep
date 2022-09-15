import java.util.Scanner;
import java.util.Stack;

public class Q88 {
    public static void main(String[] args) {
        Q88 ob = new Q88();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextInt();
        }
        int[] res = ob.nextGreaterElements(ar);
        for (int i = 0; i < n; ++i) {
            System.out.print(res[i] + " ");
        }
        in.close();
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ar = new int[2 * n];
        int k = 0;
        for (int i = 0; i < 2 * n; ++i) {
            ar[i] = nums[k++];
            if (k == n) {
                k = 0;
            }
        }
        int[] ans = new int[2 * n];
        for (int i = ar.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                ans[i] = -1;
                st.push(ar[i]);
            } else if (st.peek() > ar[i]) {
                ans[i] = st.peek();
                st.push(ar[i]);
            } else {
                while (!st.isEmpty()) {
                    if (st.peek() <= ar[i]) {
                        st.pop();
                    } else {
                        ans[i] = st.peek();
                        st.push(ar[i]);
                        break;
                    }
                }
                if (st.isEmpty()) {
                    ans[i] = -1;
                    st.push(ar[i]);
                }
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = ans[i];
        }
        return res;
    }
}
