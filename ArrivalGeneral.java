import java.util.Scanner;
public class ArrivalGeneral {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int maxVal = -1;
        int maxIndex = 0;
        int minVal = 101;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > maxVal) {
                maxVal = a[i];
                maxIndex = i;
            }
            if (a[i] <= minVal) {
                minVal = a[i];
                minIndex = i;
            }
        }
        int swaps = maxIndex + (n - 1 - minIndex);
        if (maxIndex > minIndex) {
            swaps--;
        }
        System.out.println(swaps);
    }
}