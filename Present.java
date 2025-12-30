import java.util.Scanner;
public class Present {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] result = new int[n + 1];
            for (int giver = 1; giver <= n; giver++) {
                int receiver = sc.nextInt();
                result[receiver] = giver;
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }
}