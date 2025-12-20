import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalShift {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outp = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            if (s.indexOf('0') == -1) {
                outp.append(0).append("\n");
                continue;
            }

            String dbl = s + s;

            int maxGap = 0;
            int currGap = 0;

            for (int i = 0; i < dbl.length(); i++) {
                if (dbl.charAt(i) == '0') {
                    currGap++;
                } else {
                    maxGap = Math.max(maxGap, currGap);
                    currGap = 0;
                }
            }
            maxGap = Math.max(maxGap, currGap);

            outp.append(maxGap).append("\n");
        }
        System.out.print(outp);
    }
}