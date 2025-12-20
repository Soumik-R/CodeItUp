import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rxor {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            
            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt();
            }
            
            long totalOnes = 0;
            int lastChangeableIndex = -1;
            
            for (int i = 0; i < n; i++) {
                totalOnes += a[i] + b[i];
                if (a[i] != b[i]) {
                    lastChangeableIndex = i + 1;
                }
            }
            
            if (totalOnes % 2 == 0) {
                System.out.println("Tie");
            } else {
                if (lastChangeableIndex % 2 != 0) {
                    System.out.println("Ajisai");
                } else {
                    System.out.println("Mai");
                }
            }
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