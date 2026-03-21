import java.util.Scanner;

public class MySorPrblm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int min = Math.min(x, y);
                int max = Math.max(x, y);
                System.out.println(min + " " + max);
            }
        }
    }
}