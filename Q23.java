public class Q23 {
    public static void main(String[] args) {

    }

    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        char[] ar = new char[Math.max(m, n) + 1];
        int i = m - 1;
        int j = n - 1;
        int k = ar.length - 1;
        int cy = 0;
        while (i >= 0 && j >= 0) {
            int a = num1.charAt(i--) - '0';
            int b = num2.charAt(j--) - '0';
            int sum = a + b + cy;
            ar[k--] = (char) (sum % 10 + '0');
            cy = sum / 10;
        }
        while (i >= 0) {
            int a = num1.charAt(i--) - '0';
            int sum = a + cy;
            ar[k--] = (char) (sum % 10 + '0');
            cy = sum / 10;
        }
        while (j >= 0) {
            int a = num2.charAt(j--) - '0';
            int sum = a + cy;
            ar[k--] = (char) (sum % 10 + '0');
            cy = sum / 10;
        }
        if (cy > 0) {
            ar[k--] = (char) (cy + '0');
        }
        StringBuilder sb = new StringBuilder();
        if (ar[0] > '0' && ar[0] <= '9') {
            sb.append(ar);
        } else {
            String s = String.valueOf(ar);
            sb.append(s.substring(1));
        }
        return sb.toString();
    }
}
