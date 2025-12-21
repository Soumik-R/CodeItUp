import java.util.Scanner;

public class Domino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int maxDom = (m * n) / 2;        
        System.out.println(maxDom);
    }
}