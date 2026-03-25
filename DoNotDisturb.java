import java.util.HashSet;
import java.util.Scanner;
public class DoNotDisturb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt();
                String s = scanner.next();
                HashSet<Character> seenTasks = new HashSet<>();
                boolean isSuspicious = false;
                char prevTask = s.charAt(0);
                seenTasks.add(prevTask);
                for (int i = 1; i < n; i++) {
                    char currentTask = s.charAt(i);
                    if (currentTask != prevTask) {
                        if (seenTasks.contains(currentTask)) {
                            isSuspicious = true;
                            break;
                        }
                        seenTasks.add(currentTask);
                        prevTask = currentTask;
                    }
                }
                if (isSuspicious) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}