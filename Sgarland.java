import java.io.*;
import java.util.*;

public class Sgarland {
    // Standard CP template for fast I/O
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

    static final int MOD = 998244353;
    static ArrayList<Integer>[] adj;
    static int[] depth;
    static int N, K;
    static long[] fact; // Factorials

    // Segment Tree Node
    static class Node {
        long sum;
        long mul; // Lazy multiplication tag
        Node left, right;

        public Node() {
            this.sum = 0;
            this.mul = 1;
        }
    }

    // Pool for nodes to avoid GC overhead logic, though dynamic is fine for N=3e5
    // Actually, given strict memory, we just use dynamic allocation. 
    // Java handles 3e5 * log N objects fine in 1GB.

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        // Precompute factorials
        fact = new long[300005];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) fact[i] = (fact[i - 1] * i) % MOD;

        while (t-- > 0) {
            N = sc.nextInt();
            K = sc.nextInt();

            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

            // Read parents
            for (int i = 2; i <= N; i++) {
                int p = sc.nextInt();
                adj[p].add(i);
            }

            depth = new int[N + 1];
            // Build depths via BFS or DFS
            computeDepths();

            // Solve
            Node rootRes = solve(1);
            
            // The answer is the total sum of ways in the root's distribution
            // (Root has no parent, so no "Short" constraint on the final leaf)
            System.out.println(rootRes == null ? 0 : rootRes.sum);
        }
    }

    private static void computeDepths() {
        // BFS to avoid stack overflow for depth calculation
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        depth[1] = 1;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : adj[u]){
                depth[v] = depth[u] + 1;
                q.add(v);
            }
        }
    }

    // DFS to compute DP
    // Returns the Segment Tree root representing the distribution of exit leaf depths
    private static Node solve(int u) {
        if (adj[u].isEmpty()) {
            // Leaf: returns a tree with 1 at position depth[u]
            Node node = new Node();
            update(node, 1, N, depth[u], 1);
            return node;
        }

        int m = adj[u].size();
        Node[] childTrees = new Node[m];
        long[] sVal = new long[m]; // Counts of ways valid as non-last sibling
        long[] totalVal = new long[m]; // Total counts
        int rigidCount = 0;
        int rigidIndex = -1;

        // Condition for a child to be non-last:
        // leaf_depth <= K - 1 + depth[u]
        int limit = K - 1 + depth[u];
        if (limit > N) limit = N; 

        for (int i = 0; i < m; i++) {
            int v = adj[u].get(i);
            childTrees[i] = solve(v);
            
            // Query sum in range [1, limit]
            sVal[i] = query(childTrees[i], 1, N, 1, limit);
            totalVal[i] = childTrees[i].sum;

            if (sVal[i] == 0) {
                rigidCount++;
                rigidIndex = i;
            }
        }

        if (rigidCount > 1) {
            // Impossible to satisfy requirements
            return new Node(); // Sum 0
        }

        // Calculate scalar multipliers for each child
        long baseFact = fact[m - 1];
        long[] scalars = new long[m];

        if (rigidCount == 1) {
            // We MUST pick the rigid child as last.
            // Scalar for Rigid Child = (Product of S_flexible) * (m-1)!
            long prod = 1;
            for (int i = 0; i < m; i++) {
                if (i != rigidIndex) {
                    prod = (prod * sVal[i]) % MOD;
                }
            }
            scalars[rigidIndex] = (prod * baseFact) % MOD;
            // All other scalars are 0 (cannot be last)
        } else {
            // Any child can be last.
            // Scalar[i] = (Product of S excluding i) * (m-1)!
            // Use prefix/suffix products for O(m)
            long[] pref = new long[m];
            long[] suff = new long[m];
            
            pref[0] = 1;
            for (int i = 0; i < m - 1; i++) pref[i + 1] = (pref[i] * sVal[i]) % MOD;
            
            suff[m - 1] = 1;
            for (int i = m - 1; i > 0; i--) suff[i - 1] = (suff[i] * sVal[i]) % MOD;

            for (int i = 0; i < m; i++) {
                long prod = (pref[i] * suff[i]) % MOD;
                scalars[i] = (prod * baseFact) % MOD;
            }
        }

        // Merge trees
        // Strategy: Apply scalar to each child tree (lazy), then merge all into one.
        Node res = null;
        for (int i = 0; i < m; i++) {
            if (scalars[i] == 0) continue;
            
            // Multiply child tree by scalar
            applyMul(childTrees[i], scalars[i]);
            
            // Merge into result
            res = merge(res, childTrees[i], 1, N);
        }

        return res == null ? new Node() : res;
    }

    // --- Segment Tree Operations ---

    // Apply multiplication tag
    static void applyMul(Node node, long val) {
        if (node == null) return;
        node.sum = (node.sum * val) % MOD;
        node.mul = (node.mul * val) % MOD;
    }

    // Push lazy tags down
    static void pushDown(Node node) {
        if (node.mul != 1) {
            if (node.left != null) applyMul(node.left, node.mul);
            if (node.right != null) applyMul(node.right, node.mul);
            node.mul = 1;
        }
    }

    // Point Update (Dynamic creation)
    static void update(Node node, int l, int r, int idx, long val) {
        if (l == r) {
            node.sum = (node.sum + val) % MOD;
            return;
        }
        pushDown(node);
        int mid = (l + r) / 2;
        if (idx <= mid) {
            if (node.left == null) node.left = new Node();
            update(node.left, l, mid, idx, val);
        } else {
            if (node.right == null) node.right = new Node();
            update(node.right, mid + 1, r, idx, val);
        }
        node.sum = ((node.left == null ? 0 : node.left.sum) + (node.right == null ? 0 : node.right.sum)) % MOD;
    }

    // Range Query
    static long query(Node node, int l, int r, int ql, int qr) {
        if (node == null || ql > r || qr < l) return 0;
        if (ql <= l && r <= qr) return node.sum;
        pushDown(node);
        int mid = (l + r) / 2;
        return (query(node.left, l, mid, ql, qr) + query(node.right, mid + 1, r, ql, qr)) % MOD;
    }

    // Merge two segment trees
    static Node merge(Node a, Node b, int l, int r) {
        if (a == null) return b;
        if (b == null) return a;
        
        if (l == r) {
            a.sum = (a.sum + b.sum) % MOD;
            return a;
        }
        
        pushDown(a);
        pushDown(b);
        
        int mid = (l + r) / 2;
        a.left = merge(a.left, b.left, l, mid);
        a.right = merge(a.right, b.right, mid + 1, r);
        
        a.sum = ((a.left == null ? 0 : a.left.sum) + (a.right == null ? 0 : a.right.sum)) % MOD;
        return a;
    }
}