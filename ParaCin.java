import java.util.*;
import java.io.*;
public class ParaCin {
    static class Parab {
        long a, b, c;
        int id;
        Parab(long a, long b, long c, int id) {
            this.a = a; this.b = b; this.c = c; this.id = id;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Parab[] p = new Parab[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[i] = new Parab(Long.parseLong(st.nextToken()), 
                                    Long.parseLong(st.nextToken()), 
                                    Long.parseLong(st.nextToken()), i);
            }
            boolean[][] adj = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if (isIndependent(p[i], p[j])) {
                        if (compare(p[i], p[j]) < 0) {
                            adj[i][j] = true;
                        }
                    }
                }
            }
            int[] dpStart = new int[n];
            int[] dpEnd = new int[n];
            for (int i = 0; i < n; i++) getEnd(i, adj, dpEnd);
            for (int i = 0; i < n; i++) getStart(i, adj, dpStart, n);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(dpEnd[i] + dpStart[i] - 1).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb);
        }
    }
    static boolean isIndependent(Parab p1, Parab p2) {
        long da = p1.a - p2.a;
        long db = p1.b - p2.b;
        long dc = p1.c - p2.c;
        if (da == 0) return db == 0; 
        return db * db - 4 * da * dc < 0;
    }
    static int compare(Parab p1, Parab p2) {
        if (p1.a != p2.a) return Long.compare(p1.a, p2.a);
        if (p1.b != p2.b) return Long.compare(p1.b, p2.b);
        return Long.compare(p1.c, p2.c);
    }
    static int getEnd(int u, boolean[][] adj, int[] dp) {
        if (dp[u] != 0) return dp[u];
        int res = 1;
        for (int v = 0; v < adj.length; v++) {
            if (adj[v][u]) res = Math.max(res, 1 + getEnd(v, adj, dp));
        }
        return dp[u] = res;
    }
    static int getStart(int u, boolean[][] adj, int[] dp, int n) {
        if (dp[u] != 0) return dp[u];
        int res = 1;
        for (int v = 0; v < n; v++) {
            if (adj[u][v]) res = Math.max(res, 1 + getStart(v, adj, dp, n));
        }
        return dp[u] = res;
    }
}