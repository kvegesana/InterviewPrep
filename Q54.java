import java.util.Scanner;

public class Q54 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        String abbr = in.nextLine();
        Q54 ob = new Q54();
        System.out.println(ob.validWordAbbreviation(word, abbr));
        in.close();
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder sb = new StringBuilder();
        int n = abbr.length();
        int m = word.length();
        int i = 0, j = 0;
        boolean number = false;
        int num = 0;
        while (i < n) {
            char ch = abbr.charAt(i);
            if (ch >= '0' && ch <= '9') {
                if (!number && ch == '0') {
                    return false;
                } else if (!number) {
                    number = true;
                    // num = 0;
                    num += (ch - '0');
                } else {
                    num *= 10;
                    num += (ch - '0');
                }
            } else {
                System.out.println(num);
                if (num > 0) {
                    for (int t = 0; t < num; ++t) {
                        if (j < m) {
                            sb.append(word.charAt(j++));
                        } else {
                            return false;
                        }
                    }
                    if (j < m) {
                        sb.append(ch);
                        j++;
                    } else {
                        return false;
                    }
                    System.out.println("NUM : " + sb);
                    num = 0;
                } else {
                    if (j < m) {
                        sb.append(ch);
                        j++;
                    } else {
                        return false;
                    }
                }
            }
            i++;
        }
        for (int t = 0; t < num; ++t) {
            if (j < m) {
                sb.append(word.charAt(j++));
            } else {
                return false;
            }
        }
        System.out.println(sb);
        return word.equals(sb.toString());
    }
}
