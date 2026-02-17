import java.util.Scanner;
public class Tcritics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (a + b >= 10 || a + c >= 10 || b + c >= 10) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}