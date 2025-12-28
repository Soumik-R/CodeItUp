import java.util.Scanner;

public class CalFunc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        long n = sc.nextLong();
        long res;
        if (n % 2 == 0) {
            res = n / 2;
        } else {
            res = -(n + 1) / 2;
        }
        System.out.println(res);        
    }
}