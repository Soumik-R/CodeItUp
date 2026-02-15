import java.util.*;
import java.io.*;
public class IdiotF {
    static final int MOD = 1_000_000_007;
    static int[] L, R, parent;
    static long[] S, U;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                t++; // Skip empty lines if they exist
                continue;
            }
            int n = Integer.parseInt(line.trim());
            
            L = new int[n + 1];
            R = new int[n + 1];
            parent = new int[n + 1];
            Arrays.fill(parent, -1);

            for (int i = 0; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                if (st.hasMoreTokens()) {
                    int lVal = Integer.parseInt(st.nextToken());
                    L[i] = lVal;
                    if (lVal != 0) parent[lVal] = i;
                }
                if (st.hasMoreTokens()) {
                    int rVal = Integer.parseInt(st.nextToken());
                    R[i] = rVal;
                    if (rVal != 0) parent[rVal] = i;
                }
            }

            S = new long[n + 1];
            U = new long[n + 1];
            
            // Post-order to compute subtree exit times
            computeS(0);
            // Pre-order to compute path to root times
            computeU(0);

            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= n; k++) {
                // Total time = time to leave k + time from parent to root 0
                long ans = (S[k] + U[parent[k]]) % MOD;
                sb.append(ans).append(k == n ? "" : " ");
            }
            System.out.println(sb);
        }
    }

    static void computeS(int u) {
        if (L[u] == 0 && R[u] == 0) {
            S[u] = 1;
            return;
        }
        if (L[u] != 0) computeS(L[u]);
        if (R[u] != 0) computeS(R[u]);
        
        // S[u] is the time to go from u back to parent(u)
        // If it's the root (0), we don't strictly need S[0], but for consistency:
        S[u] = (S[L[u]] + S[R[u]] + (R[u] == 0 ? 1 : 3)) % MOD;
    }

    static void computeU(int u) {
        if (L[u] == 0 && R[u] == 0) return;
        
        // If Bob arrives at u from left child
        if (L[u] != 0) {
            // Must do Right subtree then go to parent
            U[L[u]] = (1 + S[R[u]] + 1 + U[u]) % MOD;
            computeU(L[u]);
        }
        
        // If Bob arrives at u from right child
        if (R[u] != 0) {
            // Just go to parent
            U[R[u]] = (1 + U[u]) % MOD;
            computeU(R[u]);
        }
    }
}