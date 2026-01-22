import java.util.Scanner;
public class SoftD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();
        int nl = sc.nextInt();
        int np = sc.nextInt();
        int tDrTst = (k * l) / nl;
        int tLTst = c * d;
        int tSaTst = p / np;
        int maxTtl = Math.min(tDrTst, Math.min(tLTst, tSaTst));
        System.out.println(maxTtl / n);
    }
}