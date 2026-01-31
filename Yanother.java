import java.util.Scanner;
public class Yanother {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int diff = Math.abs(a - b);
                int moves = diff / 10;
                if (diff % 10 > 0) {
                    moves++;
                }
                System.out.println(moves);
            }
        }
    }
}