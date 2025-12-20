import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tcs = scanner.nextInt();
        while (tcs-- > 0) {
            solve(scanner);
        }
        scanner.close();
    }

    private static void solve(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        if (a == b && b == c && c == d) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}