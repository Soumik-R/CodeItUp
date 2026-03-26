import java.util.Scanner;
public class SimonBeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] p = new int[n];
                int maxIndex = 0;
                for (int i = 0; i < n; i++) {
                    p[i] = scanner.nextInt();
                    if (p[i] == n) {
                        maxIndex = i;
                    }
                }
                if (maxIndex != 0) {
                    int temp = p[0];
                    p[0] = p[maxIndex];
                    p[maxIndex] = temp;
                }
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    result.append(p[i]).append(" ");
                }
                System.out.println(result.toString().trim());
            }
        }
    }
}