import java.util.Scanner;
public class EqualCandy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int[] a = new int[n];
                int minCandies = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    a[i] = scanner.nextInt();
                    if (a[i] < minCandies) {
                        minCandies = a[i];
                    }
                }
                long candiesEaten = 0;
                for (int i = 0; i < n; i++) {
                    candiesEaten += (a[i] - minCandies);
                }
                System.out.println(candiesEaten);
            }
        }
    }
}