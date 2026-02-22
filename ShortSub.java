import java.util.Scanner;
public class ShortSub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String b = sc.next();
                StringBuilder a = new StringBuilder();
                a.append(b.charAt(0));
                a.append(b.charAt(1));
                for (int i = 3; i < b.length(); i += 2) {
                    a.append(b.charAt(i));
                }
                System.out.println(a.toString());
            }
        }
    }
}