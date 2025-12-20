import java.util.Scanner;
public class FarmLegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            if (n % 2 != 0) {
                System.out.println(0);
                continue;
            }
            int count = 0;
            for (int k = 0; k * 4 <= n; k++) {
                int remainLeg = n - (k * 4);
                if (remainLeg % 2 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}