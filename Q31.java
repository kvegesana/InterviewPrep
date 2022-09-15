import java.util.Stack;

public class Q31 {
    public static void main(String[] args) {

    }

    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (st.isEmpty()) {
                st.add(ch);
            } else {
                if (ch == '(') {
                    st.add(ch);
                } else {
                    if (!st.isEmpty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        st.add(ch);
                    }
                }
            }
        }
        return st.size();
    }

    // Version 2
    public int minAddToMakeValid2(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}
