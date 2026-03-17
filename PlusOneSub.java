
import java.util.Scanner;

public class PlusOneSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int i = 0; i < n; i++) {
                    int currentNumber = scanner.nextInt();
                    
                    if (currentNumber > max) {
                        max = currentNumber;
                    }
                    if (currentNumber < min) {
                        min = currentNumber;
                    }
                }
                System.out.println(max - min);
            }
        }
    }
}