import java.util.*;
import java.io.*;
public class Frog {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long x = sc.nextLong();
            long max0 = 0;
            long gBest = Long.MIN_VALUE;
            long mFinal = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                long b = sc.nextLong();
                long c = sc.nextLong();
                max0 = Math.max(max0, (b - 1) * a);
                long gi = (b * a) - c;
                gBest = Math.max(gBest, gi);
                mFinal = Math.max(mFinal, gi + (b - 1) * a);
            }
            if (max0 >= x) {
                out.println(0);
            } else if (gBest <= 0 && mFinal < x) {
                out.println(-1);
            } else {
                long need = x - mFinal;
                if (need <= 0) {
                    out.println(1);
                } else {
                    long rMinus1 = (need + gBest - 1) / gBest;
                    out.println(rMinus1 + 1);
                }
            }
        }
        out.close();
    }
}