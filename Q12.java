import java.util.Scanner;

public class Q12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Q12 ob = new Q12();
        int n = in.nextInt();
        String[] ar = new String[n];
        System.out.println(ar.length);
        for (int i = 0; i < n; ++i) {
            ar[i] = in.nextLine();
            System.out.println(ar[i]);
        }

        System.out.println(ob.longestCommonPrefix(ar));
        in.close();
    }

    public String longestCommonPrefix(String[] ar) {
        int n = ar.length;
        StringBuilder res = new StringBuilder(ar[0]);
        for (int i = 1; i < n; ++i) {
            res = new StringBuilder(longestCommonString(ar[i].toCharArray(), res.toString().toCharArray()));
            System.out.println(res);
        }
        return res.toString();
    }

    public String longestCommonString(char[] ar, char[] br) {
        if (ar.length > br.length) {
            char[] temp = ar;
            ar = br;
            br = temp;
        }
        int i = 0, j = 0;
        while (i < ar.length && j < br.length) {
            if (ar[i] == br[j]) {
                i++;
                j++;
            } else {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < i; ++k) {
            sb.append(ar[k]);
        }

        return sb.toString();
    }
}
