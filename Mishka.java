import java.util.Scanner;
public class Mishka {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mishkaWins = 0;
        int chrisWins = 0;
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int c = sc.nextInt();
            
            if (m > c) {
                mishkaWins++;
            } else if (c > m) {
                chrisWins++;
            }
        }
        if (mishkaWins > chrisWins) {
            System.out.println("Mishka");
        } else if (chrisWins > mishkaWins) {
            System.out.println("Chris");
        } else {
            System.out.println("Friendship is magic!^^");
        }
    }
}