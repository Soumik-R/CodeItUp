import java.util.Scanner;
public class SimpleSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                StringBuilder result = new StringBuilder();
                for (int i = n; i >= 1; i--) {
                    result.append(i).append(" ");
                }
                System.out.println(result.toString().trim());
            }
        }
    }
}