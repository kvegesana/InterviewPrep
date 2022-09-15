import java.util.Stack;

public class Q38 {
    public static void main(String[] args) {

    }

    public String removeDuplicates(String s) {
        int n = s.length();
        if (n <= 1)
            return s;
        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));
        for (int i = 1; i < n; ++i) {
            char c = s.charAt(i);
            if (st.isEmpty()) {
                st.add(c);
            } else if (st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        int size = st.size();
        for (int i = 0; i < size; ++i) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    // Version 2
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }
}
