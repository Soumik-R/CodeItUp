import java.util.Scanner;
public class DieRollll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int w = sc.nextInt();
        int max = Math.max(y, w);
        int outcomes = 6 - max + 1;
        String[] probabilities = {"0/1", "1/6", "1/3", "1/2", "2/3", "5/6", "1/1"};
        System.out.println(probabilities[outcomes]);
    }
}