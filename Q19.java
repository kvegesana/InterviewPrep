import java.util.Scanner;

public class Q19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q19 ob = new Q19();
        String s = in.nextLine();
        System.out.println(ob.validPalindrome(s));
        in.close();
    }

    public boolean validPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                break;
            }
        }
        if (l >= r)
            return true;
        return isPalindrome(s.substring(l + 1, r + 1)) || isPalindrome(s.substring(l, r));
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
