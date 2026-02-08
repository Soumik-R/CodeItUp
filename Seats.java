import java.util.*;
import java.io.*;
public class Seats {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            char[] seats = s.toCharArray();
            int total = 0;
            for (int i = 0; i < n; i++) {
                if (seats[i] == '1') {
                    total++;
                    continue;
                }
                boolean canSit = true;
                if (i > 0 && seats[i - 1] == '1') canSit = false;
                if (i < n - 1 && seats[i + 1] == '1') canSit = false;
                if (canSit) { 
                    if (i + 1 < n && seats[i + 1] == '0') {
                        if (i + 2 >= n || seats[i + 2] == '0') {
                            seats[i + 1] = '1';
                            total++;
                            i++;
                            continue;
                        }
                    }
                    seats[i] = '1';
                    total++;
                }
            }
            System.out.println(total);
        }
    }
}