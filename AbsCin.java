import java.util.*;
import java.io.*;

public class AbsCin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] f = new long[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                f[i] = Long.parseLong(st.nextToken());
            }
            if (n == 2) {
                out.println(f[2] + " " + f[1]);
                continue;
            }
            long[] a = new long[n + 1];
            long sumMid = 0;
            long wSumMid = 0;
            for (int i = 2; i < n; i++) {
                a[i] = (f[i + 1] - 2 * f[i] + f[i - 1]) / 2;
                sumMid += a[i];
                wSumMid += a[i] * (i - 1);
            }
            long diff = f[2] - f[1];
            long tar = f[1] - wSumMid + (n - 1) * (sumMid + diff);
            a[1] = tar / (n - 1);
            a[n] = a[1] - sumMid - diff;

            for (int i = 1; i <= n; i++) {
                out.print(a[i] + (i == n ? "" : " "));
            }
            out.println();
        }
        out.flush();
    }
}