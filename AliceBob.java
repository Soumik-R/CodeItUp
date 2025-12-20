// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class AliceBob {
//     public static void main(String[] args) {
//         FastScanner fs = new FastScanner();
//         int t = fs.nextInt();
        
//         while (t-- > 0) {
//             int n = fs.nextInt();
//             int a = fs.nextInt();
            
//             int left = 0;
//             int right = 0;
            
//             for (int i = 0; i < n; i++) {
//                 int v = fs.nextInt();
//                 if (v < a) {
//                     left++;
//                 } else if (v > a) {
//                     right++;
//                 }
//             }
            
//             if (left >= right) {
//                 System.out.println(Math.max(0, a - 1));
//             } else {
//                 System.out.println(a + 1);
//             }
//         }
//     }    
//     static class FastScanner {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer("");
        
//         String next() {
//             while (!st.hasMoreTokens()) {
//                 try {
//                     String line = br.readLine();
//                     if (line == null) return null;
//                     st = new StringTokenizer(line);
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             return st.nextToken();
//         }
        
//         int nextInt() {
//             return Integer.parseInt(next());
//         }
//     }
// }