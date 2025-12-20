import java.util.Scanner;

public class Bit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int x = 0;            
            for (int i = 0; i < n; i++) {
                String statement = scanner.next();
                if (statement.charAt(1) == '+') {
                    x++;
                } else {
                    x--;
                }
            }            
            System.out.println(x);
        }
    }
}