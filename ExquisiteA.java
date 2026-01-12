import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class ExquisiteA {
    static int[] parent;
    static int[] size;
    static boolean[] active;
    static long currentAns;
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = fs.nextInt();
            }
            ArrayList<Integer>[] buckets = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                buckets[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int diff = Math.abs(p[i] - p[i + 1]);
                buckets[diff].add(i);
            }
            parent = new int[n - 1];
            size = new int[n - 1];
            active = new boolean[n - 1];
            for (int i = 0; i < n - 1; i++) {
                parent[i] = i;
                size[i] = 1;
                active[i] = false;
            }
            currentAns = 0;
            long[] results = new long[n];
            for (int k = n - 1; k >= 1; k--) {
                for (int idx : buckets[k]) {
                    activate(idx, n - 1);
                }
                results[k] = currentAns;
            }
            for (int k = 1; k < n; k++) {
                out.print(results[k] + " ");
            }
            out.println();
        }
        out.flush();
    }
    static void activate(int i, int limit) {
        active[i] = true;
        currentAns += 1;
        if (i > 0 && active[i - 1]) {
            union(i - 1, i);
        }
        if (i < limit - 1 && active[i + 1]) {
            union(i, i + 1);
        }
    }
    static int find(int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }
    static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            long sizeI = size[rootI];
            long sizeJ = size[rootJ];
            currentAns -= (sizeI * (sizeI + 1)) / 2;
            currentAns -= (sizeJ * (sizeJ + 1)) / 2;
            parent[rootJ] = rootI;
            size[rootI] += sizeJ;
            long newSize = size[rootI];
            currentAns += (newSize * (newSize + 1)) / 2;
        }
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