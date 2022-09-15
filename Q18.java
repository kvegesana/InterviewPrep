import java.util.Scanner;
import java.util.Stack;

public class Q18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q18 ob = new Q18();
        String s = in.nextLine();
        System.out.println(ob.minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (count <= 0 && c == ')')
                continue;
            else if (c >= 'a' && c <= 'z')
                st.push(c);
            else {
                if (c == '(') {
                    st.push(c);
                    count++;
                } else {
                    count--;
                    st.push(c);
                }
            }
        }
        // System.out.println(count + " Count");
        StringBuilder sb = new StringBuilder();
        int size = st.size();
        for (int i = 0; i < size; ++i) {
            char c = st.pop();
            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else {
                if (count > 0 && c == '(') {
                    count--;
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.reverse().toString();
    }
}
