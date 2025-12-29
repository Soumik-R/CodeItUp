import java.io.*;
import java.util.*;
public class ChristmasR {
    static final int MOD = 998244353;
    static long[][] C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = new long[505][505];
        for (int i = 0; i <= 500; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cnt = new int[65];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }
        int crrN = n;
        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int x = Integer.parseInt(st.nextToken());
                cnt[x]++;
                crrN++;
            } else if (type == 2) {
                int x = Integer.parseInt(st.nextToken());
                cnt[x]--;
                crrN--;
            } else {
                long xVal = Long.parseLong(st.nextToken());
                out.println(solve(crrN, cnt, xVal));
            }
        }
        out.flush();
    }
    private static int solve(int ttldeer, int[] cnt, long X) {
        long[][] dp = new long[ttldeer + 1][2];
        dp[0][1] = 1;
        for (int s = 60; s >= 0; s--) {
            int cntS = cnt[s];
            long[][] nextDp = new long[ttldeer + 1][2];
            for (int j = 0; j <= ttldeer; j++) {
                if (dp[j][0] == 0 && dp[j][1] == 0) continue;
                for (int u = 0; u <= cntS; u++) {
                    if (j + u > ttldeer) break;
                    long ways = C[cntS][u];
                    int cmp = 0;
                    for (int k = 0; k < u; k++) {
                        int bitPos = s - j - k;
                        int xBit = getBit(X, bitPos);
                        
                        if (1 > xBit) { cmp = 1; break; }
                        if (1 < xBit) { cmp = -1; break; }
                    }
                    if (cmp == 0) {
                        int zBitPos = s - j - u;
                        int xBit = getBit(X, zBitPos);
                        if (0 > xBit) cmp = 1;
                        else if (0 < xBit) cmp = -1;
                    }
                    if (dp[j][0] > 0) {
                        nextDp[j + u][0] = (nextDp[j + u][0] + dp[j][0] * ways) % MOD;
                    }
                    if (dp[j][1] > 0) {
                        if (cmp == 1) {
                            nextDp[j + u][0] = (nextDp[j + u][0] + dp[j][1] * ways) % MOD;
                        } else if (cmp == 0) {
                            nextDp[j + u][1] = (nextDp[j + u][1] + dp[j][1] * ways) % MOD;
                        }
                    }
                }
            }
            dp = nextDp;
        }
        long ans = 0;
        for (int j = 0; j <= ttldeer; j++) {
            ans = (ans + dp[j][0] + dp[j][1]) % MOD;
        }
        return (int) ans;
    }
    private static int getBit(long X, int pos) {
        if (pos < 0) return 0;
        if (pos > 62) return 0;
        return (int)((X >> pos) & 1);
    }
}