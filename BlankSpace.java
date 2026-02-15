import java.util.Scanner;
public class BlankSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int maxZeros = 0;
            int currentZeros = 0;
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val == 0) {
                    currentZeros++;
                    if (currentZeros > maxZeros) {
                        maxZeros = currentZeros;H
                    }
                } else {
                    currentZeros = 0;
                }
            }
            System.out.println(maxZeros);
        }
    }
}