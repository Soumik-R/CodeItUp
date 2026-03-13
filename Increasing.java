import java.util.HashSet;
import java.util.Scanner;
public class Increasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                HashSet<Integer> uniqueNumbers = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    int num = scanner.nextInt();
                    uniqueNumbers.add(num);
                }
                if (uniqueNumbers.size() == n) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}