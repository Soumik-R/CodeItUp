import java.util.Scanner;
public class MinsB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            int current = h * 60 + m;
            int ans = 1440 - current;
            System.out.println(ans);
        }
    }
}
