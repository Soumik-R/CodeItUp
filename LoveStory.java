import java.util.Scanner;
public class LoveStory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        String target = "codeforces";
        while (t-- > 0) {
            String s = sc.next();
            int diffCount = 0;
            for (int i = 0; i < 10; i++) {
                if (s.charAt(i) != target.charAt(i)) {
                    diffCount++;
                }
            }
            System.out.println(diffCount);
        }
    }
}