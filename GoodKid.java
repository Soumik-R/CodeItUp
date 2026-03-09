import java.util.Arrays;
import java.util.Scanner;
public class GoodKid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                }
                Arrays.sort(a);
                a[0]++;
                long product = 1;
                for (int i = 0; i < n; i++) {
                    product *= a[i];
                }
                System.out.println(product);
            }
        }
    }
}