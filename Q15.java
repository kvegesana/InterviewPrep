import java.util.Scanner;
import java.util.Stack;

public class Q15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q15 ob = new Q15();
        String s = in.nextLine();
        System.out.println(ob.isValid(s));
        in.close();
    }

    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.size() == 0)
                    return false;
                char ch = st.pop();
                if (c == ')' && ch != '(')
                    return false;
                if (c == '}' && ch != '{')
                    return false;
                if (c == ']' && ch != '[')
                    return false;
            }
        }
        return st.size() > 0 ? false : true;
    }
}
