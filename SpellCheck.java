import java.util.Scanner;
import java.util.Arrays;
public class SpellCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        char[] target = "Timur".toCharArray();
        Arrays.sort(target);
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            if (n != 5) {
                System.out.println("NO");
                continue;
            }
            char[] current = s.toCharArray();
            Arrays.sort(current);
            if (Arrays.equals(current, target)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}