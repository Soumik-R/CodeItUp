import java.util.*;
import java.io.*;
public class Heapy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            boolean poss = true;
            boolean[] vis = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!vis[i]) {
                    List<Integer> pos = new ArrayList<>();
                    List<Integer> val = new ArrayList<>();
                    int curr = i;
                    while (curr <= n) {
                        vis[curr] = true;
                        pos.add(curr);
                        val.add(a[curr]);
                        if (curr > n / 2) break; 
                        curr *= 2;
                    }
                    Collections.sort(pos);
                    Collections.sort(val);
                    if (!pos.equals(val)) {
                        poss = false;
                        break;
                    }
                }
            }
            System.out.println(poss ? "YES" : "NO");
        }
    }
}