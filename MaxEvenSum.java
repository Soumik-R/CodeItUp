import java.util.Scanner;

public class MaxEvenSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long ans = -1;

            // Try all divisors of b
            for (long k = 1; k * k <= b; k++) {
                if (b % k == 0) {
                    // k is a divisor
                    long[] ks = {k, b / k};
                    for (long div : ks) {
                        long newA = a * div;
                        long newB = b / div;
                        long sum = newA + newB;
                        if (sum % 2 == 0) ans = Math.max(ans, sum);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}