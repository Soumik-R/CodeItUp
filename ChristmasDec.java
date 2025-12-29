import java.util.Scanner;
public class ChristmasDec {
    static final long MOD = 998244353L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] a = new long[n + 1];
                long sum = 0;
                for (int i = 0; i <= n; i++) {
                    a[i] = sc.nextLong();
                    sum += a[i];
                }
                long k = sum / n;
                long r = sum % n;                
                int cntA = 0;
                boolean poss = true;
                for (int i = 1; i <= n; i++) {
                    if (a[i] <= k) {
                        cntA++;
                    } else if (a[i] > k + 1) {
                        poss = false;
                    }
                }                
                if (!poss || cntA < (n - r)) {
                    System.out.println(0);
                } else {
                    long ans = perm(cntA, (int)(n - r));
                    ans = (ans * fact((int)r)) % MOD;
                    System.out.println(ans);
                }
            }
        }
    }    
    static long fact(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }
    static long perm(int n, int k) {
        if (k < 0 || k > n) return 0;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * (n - i)) % MOD;
        }
        return res;
    }
}