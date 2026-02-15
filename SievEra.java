import java.util.Scanner;
public class SievEra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < n; i++) {
                    int a = sc.nextInt();
                    if (a == 67) {
                        found = true;
                    }
                }
                if (found) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}