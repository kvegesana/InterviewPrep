import java.util.Stack;

public class Q73 {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        char op = '+';
        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            }
            if ((!Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) || i == n - 1) {
                if (op == '+') {
                    st.push(num);
                } else if (op == '-') {
                    st.push(-num);
                } else if (op == '*') {
                    st.push(st.pop() * num);
                } else if (op == '/') {
                    st.push(st.pop() / num);
                }
                num = 0;
                op = s.charAt(i);
            }
        }
        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}
