import java.util.Scanner;
public class Lasers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long x = sc.nextLong();
            long y = sc.nextLong();

            long[] a = new long[n];
            long[] b = new long[m];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            for (int j = 0; j < m; j++) {
                b[j] = sc.nextLong();
            }

            System.out.println(n + m);
        }
        sc.close();
    }
}
