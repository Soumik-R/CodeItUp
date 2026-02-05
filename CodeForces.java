import java.util.Scanner;
public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = "codeforces";
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char inputChar = sc.next().charAt(0);
                if (target.indexOf(inputChar) != -1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}