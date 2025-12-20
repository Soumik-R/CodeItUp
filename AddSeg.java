// import java.io.*;
// import java.util.*;

// public class AddSeg {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter out = new PrintWriter(System.out);
//         StringTokenizer st;

//         String line = br.readLine();
//         if (line == null) return;
//         int t = Integer.parseInt(line.trim());

//         while (t-- > 0) {
//             line = br.readLine();
//             while (line != null && line.trim().isEmpty()) line = br.readLine();
//             if (line == null) break;

//             int n = Integer.parseInt(line.trim());
            
//             long sumB = 0;
//             int[] freq = new int[n + 2];
            
//             line = br.readLine();
//             st = new StringTokenizer(line);
//             for (int i = 0; i < n; i++) {
//                 int val = Integer.parseInt(st.nextToken());
//                 sumB += val;
//                 freq[val]++;
//             }

//             long[] b_star = new long[n + 1];
//             int currentCount = 0;
//             for (int v = n; v >= 1; v--) {
//                 currentCount += freq[v];
//                 b_star[v] = currentCount; 
//             }
//             long low = 1;
//             long nonZeros = b_star[1];
//             long maxTheoretical = sumB - n + 1; 
//             long high = Math.min(nonZeros, maxTheoretical);
//             long ans = 1;

//             if (high < low) {
//                 out.println(1);
//                 continue;
//             }

//             while (low <= high) {
//                 long mid = low + (high - low) / 2;
//                 if (check(mid, n, sumB, b_star)) {
//                     ans = mid;
//                     low = mid + 1;
//                 } else {
//                     high = mid - 1;
//                 }
//             }

//             out.println(ans);
//         }
//         out.flush();
//     }
//     private static boolean check(long K, int n, long sumB, long[] b_star) {
//         long remainder = sumB - K;
//         if (remainder < n - 1) return false;
//         long count = n - 1;
//         long base = (count == 0) ? 0 : remainder / count;
//         long rem = (count == 0) ? 0 : remainder % count;
        
//         long currentLSum = 0;
//         long currentBSum = 0;
        
//         long val1 = K;
//         long val2 = base + 1;
//         long val3 = base;
        
//         int count1 = 1;
//         int count2 = (int)rem;
//         int count3 = (int)(count - rem);
                
//         for (int i = 1; i <= n; i++) {
//             long pick;
//             long maxV = -1;
//             int type = 0;
            
//             if (count1 > 0) { maxV = val1; type = 1; }
//             if (count2 > 0 && val2 > maxV) { maxV = val2; type = 2; }
//             if (count3 > 0 && val3 > maxV) { maxV = val3; type = 3; }
            
//             if (type == 1) count1--;
//             else if (type == 2) count2--;
//             else count3--;
            
//             currentLSum += maxV;
            
//             long bVal = (i < b_star.length) ? b_star[i] : 0;
//             currentBSum += bVal;
            
//             if (currentBSum < currentLSum) return false;
//         }
        
//         return true;
//     }
// }