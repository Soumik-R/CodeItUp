import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class MonG {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuilder out = new StringBuilder();
        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);
        while (t-- > 0) {
            int n = sc.nextInt();
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a, (x, y) -> Integer.compare(y, x));
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            long maxSc = 0;
            long nSword = 0;
            for (int i = 0; i < n; i++) {
                nSword += b[i];
                if (nSword > n) {
                    break;
                }
                long lComp = i + 1;
                long diff = a[(int) nSword - 1];
                long currSc = lComp * diff;
                if (currSc > maxSc) {
                    maxSc = currSc;
                }
            }
            out.append(maxSc).append("\n");
        }
        System.out.print(out);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String ln = br.readLine();
                    if (ln == null) return null;
                    st = new StringTokenizer(ln);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}