import java.util.Scanner;
public class CandyAndSis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                long n = sc.nextLong();
                System.out.println((n - 1) / 2);
            }
        }
    }
}