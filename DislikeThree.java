import java.util.Scanner;

public class DislikeThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int k = sc.nextInt();
                int currentNumber = 0;
                int countLiked = 0;
                while (countLiked < k) {
                    currentNumber++;
                    if (currentNumber % 3 != 0 && currentNumber % 10 != 3) {
                        countLiked++;
                    }
                }
                System.out.println(currentNumber);
            }
        }
    }
}