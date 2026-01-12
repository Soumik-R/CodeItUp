import java.io.*;
import java.util.*;
public class Nastiness {
    static class SegmentTree {
        int n;
        int[] tree;
        public SegmentTree(int n, int[] arr) {
            this.n = n;
            tree = new int[4 * n + 1];
            build(1, 1, n, arr);
        }
        private void build(int node, int start, int end, int[] arr) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(2 * node, start, mid, arr);
                build(2 * node + 1, mid + 1, end, arr);
                tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
            }
        }
        public void update(int idx, int val) {
            update(1, 1, n, idx, val);
        }
        private void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    update(2 * node, start, mid, idx, val);
                } else {
                    update(2 * node + 1, mid + 1, end, idx, val);
                }
                tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
            }
        }
        public int query(int l, int r) {
            if (r < l) return Integer.MAX_VALUE;
            return query(1, 1, n, l, r);
        }
        private int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return Integer.MAX_VALUE;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int p1 = query(2 * node, start, mid, l, r);
            int p2 = query(2 * node + 1, mid + 1, end, l, r);
            return Math.min(p1, p2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] a = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            SegmentTree stree = new SegmentTree(n, a);
            for (int k = 0; k < q; k++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    int i = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());
                    stree.update(i, x);
                } else {
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    int low = 0;
                    int high = r - l;
                    int ans = 0;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        int minVal = stree.query(l, l + mid);
                        if (minVal == mid) {
                            ans = 1;
                            break;
                        } else if (minVal > mid) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                    out.println(ans);
                }
            }
        }
        out.flush();
    }
}