import java.io.*;
import java.util.*;

public class NeedleHay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        String line = br.readLine();
        if (line == null) return;
        int T = Integer.parseInt(line.trim());
        
        while (T-- > 0) {
            String s = br.readLine();
            String t = br.readLine();
            
            if (s == null || t == null) break;
            
            solve(s.trim(), t.trim(), out);
        }
        out.flush();
    }

    private static void solve(String s, String t, PrintWriter out) {
        int[] sCount = new int[26];
        int[] tCount = new int[26];

        for (char c : s.toCharArray()) sCount[c - 'a']++;
        for (char c : t.toCharArray()) tCount[c - 'a']++;

        int[] extras = new int[26];
        
        for (int i = 0; i < 26; i++) {
            if (tCount[i] < sCount[i]) {
                out.println("Impossible");
                return;
            }
            extras[i] = tCount[i] - sCount[i];
        }

        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            int charIndex = c - 'a';
            
            for (int i = 0; i < charIndex; i++) {
                while (extras[i] > 0) {
                    sb.append((char)('a' + i));
                    extras[i]--;
                }
            }
            
            sb.append(c);
        }

        for (int i = 0; i < 26; i++) {
            while (extras[i] > 0) {
                sb.append((char)('a' + i));
                extras[i]--;
            }
        }

        out.println(sb.toString());
    }
}