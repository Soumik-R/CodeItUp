import java.util.*;
import java.io.*;
public class ArrayPer {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] p = new int[n];
            int[] pos = new int[n + 1];
            for (int i = 0; i < n; i++) {
                p[i] = fr.nextInt();
                pos[p[i]] = i;
            }
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
            }
            List<Integer> compressed = new ArrayList<>();
            if (n > 0) {
                compressed.add(a[0]);
                for (int i = 1; i < n; i++) {
                    if (a[i] != a[i - 1]) {
                        compressed.add(a[i]);
                    }
                }
            }
            boolean possible = true;
            for (int i = 0; i < compressed.size() - 1; i++) {
                if (pos[compressed.get(i)] > pos[compressed.get(i + 1)]) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
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
                    st = new StringTokenizer(br.readLine());
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