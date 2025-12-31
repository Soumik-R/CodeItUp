import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Pangram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        if (n < 26) {
            System.out.println("NO");
            return;
        }
        s = s.toLowerCase();
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                uniqueChars.add(c);
            }
        }
        if (uniqueChars.size() == 26) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}