import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class HugePile {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            if (n == k) {
                out.println(0);
                continue;
            }
            if (k > n) {
                out.println(-1);
                continue;
            }
            int ans = -1;
            for (int d = 1; d <= 31; d++) {
                long parts = 1L << d;
                long valFloor = n / parts;
                long valCeil = (n + parts - 1) / parts;
                if (valFloor == k || valCeil == k) {
                    ans = d;
                    break;
                }
                if (valCeil < k) {
                    break;
                }
            }
            out.println(ans);
        }
        out.close();
    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
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