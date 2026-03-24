import java.util.Arrays;
import java.util.Scanner;
public class FlipFlops {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                long c = scanner.nextLong();
                long k = scanner.nextLong();
                long[] a = new long[n];
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextLong();
                }
                Arrays.sort(a);
                for (int i = 0; i < n; i++) {
                    if (a[i] > c) {
                        break;
                    }
                    long maxBuffCapacity = c - a[i];
                    long flipFlopsToUse = Math.min(k, maxBuffCapacity);
                    k -= flipFlopsToUse;
                    c += (a[i] + flipFlopsToUse);
                }
                System.out.println(c);
            }
        }
    }
}