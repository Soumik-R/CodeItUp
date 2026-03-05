import java.util.Scanner;

public class HalloumiBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            if (k >= 2) {
                System.out.println("YES");
            } else {
                boolean isSorted = true;
                for (int i = 1; i < n; i++) {
                    if (a[i] < a[i - 1]) {
                        isSorted = false;
                        break;
                    }
                }
                
                if (isSorted) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}