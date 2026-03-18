import java.util.ArrayList;
import java.util.Scanner;
public class Cyclist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                int p = scanner.nextInt();
                int m = scanner.nextInt();
                ArrayList<Integer> deck = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    deck.add(scanner.nextInt());
                }
                int targetIndex = p - 1; 
                int plays = 0;

                while (true) {
                    if (targetIndex < k) {
                        int cost = deck.get(targetIndex);
                        if (m >= cost) {
                            m -= cost;
                            plays++;
                            deck.remove(targetIndex);
                            deck.add(cost);
                            targetIndex = n - 1;
                        } else {
                            break; 
                        }
                    }
                    else {
                        int minCost = Integer.MAX_VALUE;
                        int minIdx = -1;
                        for (int i = 0; i < k; i++) {
                            if (deck.get(i) < minCost) {
                                minCost = deck.get(i);
                                minIdx = i;
                            }
                        }
                        if (m >= minCost) {
                            m -= minCost;
                            deck.remove(minIdx);
                            deck.add(minCost);
                            targetIndex--;
                        } else {
                            break; 
                        }
                    }
                }
                
                System.out.println(plays);
            }
        }
    }
}