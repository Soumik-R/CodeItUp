import java.util.Scanner;

public class Arrayy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    int greaterCount = 0;
                    int lessCount = 0;
                    for (int j = i + 1; j < n; j++) {
                        if (a[j] > a[i]) {
                            greaterCount++;
                        } else if (a[j] < a[i]) {
                            lessCount++;
                        }
                    }
                    result.append(Math.max(greaterCount, lessCount)).append(" ");
                }
                System.out.println(result.toString().trim());
            }
        }
    }
}