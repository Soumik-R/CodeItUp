import java.util.Arrays;
import java.util.Scanner;
public class RemS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                Arrays.sort(a);
                boolean poss = true;
                for (int i = 0; i < n - 1; i++) {
                    if (a[i + 1] - a[i] > 1) {
                        poss = false;
                        break;
                    }
                }
                if (poss) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}