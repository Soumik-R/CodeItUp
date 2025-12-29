import java.util.Scanner;
public class Magnet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String prev = sc.next();
        int grp = 1;
        for (int i = 1; i < n; i++) {
            String curr = sc.next();
            if (!curr.equals(prev)) {
                grp++;
            }
            prev = curr;
        }
        System.out.print(grp);
    }
}
