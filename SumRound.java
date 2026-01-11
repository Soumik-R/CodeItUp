import java.util.ArrayList;
import java.util.Scanner;
public class SumRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                ArrayList<Integer> rnd = new ArrayList<>();
                int power = 1;
                while (n > 0) {
                    int digit = n % 10;
                    if (digit > 0) {
                        rnd.add(digit * power);
                    }
                    n /= 10;
                    power *= 10;
                }
                System.out.println(rnd.size());
                for (int num : rnd) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}