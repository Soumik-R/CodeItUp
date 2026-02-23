import java.util.Scanner;
public class PreApend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String s = sc.next();
                int left = 0;
                int right = n - 1;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        left++;
                        right--;
                    } else {
                        break;
                    }
                }
                System.out.println(right - left + 1);
            }
        }
    }
}