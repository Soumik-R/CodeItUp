import java.util.Scanner;
public class BingoCandy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int maxColor = n * n;
                int[] counts = new int[maxColor + 1];
                int maxFreq = 0;
                for (int i = 0; i < n * n; i++) {
                    int color = scanner.nextInt();
                    counts[color]++;
                    if (counts[color] > maxFreq) {
                        maxFreq = counts[color];
                    }
                }
                if (maxFreq <= (n * n) - n) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}