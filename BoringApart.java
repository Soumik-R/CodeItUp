import java.util.Scanner;
public class BoringApart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                String x = scanner.next();
                int digit = x.charAt(0) - '0';
                int len = x.length();
                int prevGrp = (digit - 1) * 10;
                int currGrp = (len * (len + 1)) / 2;
                System.out.println(prevGrp + currGrp);
            }
        }
    }
}