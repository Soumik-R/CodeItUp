import java.util.Scanner;

public class BeautifulXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == b) {
                System.out.println("0");
                continue;
            }

            int p = 1;
            while (p <= a) {
                p <<= 1;
            }

            if (b >= p) {
                System.out.println("-1");
                continue;
            }

            int c = a ^ b;
            if (c <= a) {
                System.out.println("1");
                System.out.println(c);
                continue;
            }

            int intermediate_val = a | b;
            int x1 = a ^ intermediate_val;
            int x2 = intermediate_val ^ b;

            System.out.println("2");
            System.out.println(x1 + " " + x2);
        }
        
        sc.close();
    }
}