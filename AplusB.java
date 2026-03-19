import java.util.Scanner;
public class AplusB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                String equation = scanner.next();
                int a = equation.charAt(0) - '0';
                int b = equation.charAt(2) - '0';
                System.out.println(a + b);
            }
        }
    }
}