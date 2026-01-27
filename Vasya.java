import java.util.Scanner;
public class Vasya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Math.min(a, b);
        int rem = Math.abs(a - b);
        int sameC = rem / 2;
        System.out.println(fa + " " + sameC);
    }
}
