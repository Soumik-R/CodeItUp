import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class PQue {
    public static void main(String[] args) {
        FReader sc = new FReader();
        StringBuilder out = new StringBuilder();
        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] dis = new int[n + 1];
            Arrays.fill(dis, -1);
            int[] q = new int[n + 5];
            int he = 0;
            int ta = 0;
            boolean[] pres = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (!pres[val]) {
                    pres[val] = true;
                    if (dis[val] == -1) {
                        dis[val] = 1;
                        q[ta++] = val;
                    }
                }
            }
            int[] mults = new int[n];
            int mCount = 0;
            for (int i = 2; i <= n; i++) {
                if (pres[i]) {
                    mults[mCount++] = i;
                }
            }
            while (he < ta) {
                int u = q[he++];
                for (int i = 0; i < mCount; i++) {
                    int x = mults[i];
                    long nxtValL = (long) u * x;
                    if (nxtValL > n) {
                        break;
                    }
                    int v = (int) nxtValL;
                    if (dis[v] == -1) {
                        dis[v] = dis[u] + 1;
                        q[ta++] = v;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                out.append(dis[i]).append(" ");
            }
            out.append("\n");
        }
        System.out.print(out);
    }
    static class FReader {
        BufferedReader br;
        StringTokenizer st;
        public FReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
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