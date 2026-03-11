import java.util.Scanner;
public class BladBf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                String s = scanner.next();
                int countA = 0;
                for (int i = 0; i < 5; i++) {
                    if (s.charAt(i) == 'A') {
                        countA++;
                    }
                }
                if (countA > 2) {
                    System.out.println("A");
                } else {
                    System.out.println("B");
                }
            }
        }
    }
}