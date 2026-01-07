import java.util.Scanner;
public class BinaryArrGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                int fZIdx = -1;
                int lZIdx = -1;
                boolean hasZero = false;
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                    if (a[i] == 0) {
                        if (!hasZero) {
                            fZIdx = i;
                        }
                        lZIdx = i;
                        hasZero = true;
                    }
                }
                if (!hasZero) {
                    System.out.println("Alice");
                } else {
                    if (fZIdx == 0 && lZIdx == n - 1) {
                        System.out.println("Bob");
                    } else {
                        System.out.println("Alice");
                    }
                }
            }
        }
    }
}