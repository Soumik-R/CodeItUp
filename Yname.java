import java.util.Scanner;
import java.util.Arrays;

public class Yname {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            String t = sc.next();

            if (s.length() != t.length()) {
                System.out.println("NO");
                continue;
            }

            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            Arrays.sort(sChars);
            Arrays.sort(tChars);

            if (Arrays.equals(sChars, tChars)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}