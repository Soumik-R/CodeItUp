import java.util.Scanner;
public class HolidayEq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] a = new int[n];
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > maxVal) {
                maxVal = a[i];
            }
        }
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalCost += (maxVal - a[i]);
        }
        System.out.println(totalCost);
    }
}