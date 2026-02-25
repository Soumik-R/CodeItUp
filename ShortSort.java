import java.util.Scanner;
public class ShortSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            
            if (s.charAt(0) == 'a' || s.charAt(1) == 'b' || s.charAt(2) == 'c') {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}