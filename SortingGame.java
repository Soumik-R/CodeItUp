import java.util.ArrayList;
import java.util.Scanner;
public class SortingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                String s = scanner.next();
                int totalZeros = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        totalZeros++;
                    }
                }
                ArrayList<Integer> misplacedIndices = new ArrayList<>();
                for (int i = 0; i < totalZeros; i++) {
                    if (s.charAt(i) == '1') {
                        misplacedIndices.add(i + 1);
                    }
                }
                for (int i = totalZeros; i < n; i++) {
                    if (s.charAt(i) == '0') {
                        misplacedIndices.add(i + 1);
                    }
                }
                if (misplacedIndices.isEmpty()) {
                    System.out.println("Bob");
                } else {
                    System.out.println("Alice");
                    System.out.println(misplacedIndices.size());
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < misplacedIndices.size(); i++) {
                        sb.append(misplacedIndices.get(i)).append(i == misplacedIndices.size() - 1 ? "" : " ");
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}