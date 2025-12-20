import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int count = 0;

        for (int i = 0; i < n; i++) {
            int pet = sc.nextInt();
            int vas = sc.nextInt();
            int ton = sc.nextInt();

            if (pet + vas + ton >= 2) {
                count++;
            }
        }

        System.out.println(count);        
    }
}