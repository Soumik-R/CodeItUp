import java.io.*;
import java.util.*;

public class Niko {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            
            long[] a = new long[n];
            long[] b = new long[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(st.nextToken());
            }
            
            long pl = 0;
            long mi = -2_000_000_000_000_000_000L;
            
            for (int i = n - 1; i >= 0; i--) {
                long nextPlus = Math.max(pl - a[i], mi - b[i]);
                long nextMinus = Math.max(mi + a[i], pl + b[i]);
                
                pl = nextPlus;
                mi = nextMinus;
            }
            
            sb.append(Math.max(pl, mi)).append("\n");
        }
        System.out.print(sb);
    }
}