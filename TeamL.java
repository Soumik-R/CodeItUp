import java.util.ArrayList;
import java.util.Scanner;
public class TeamL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            ArrayList<Integer> programmers = new ArrayList<>();
            ArrayList<Integer> mathematicians = new ArrayList<>();
            ArrayList<Integer> sportspeople = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int skill = scanner.nextInt();
                
                if (skill == 1) {
                    programmers.add(i);
                } else if (skill == 2) {
                    mathematicians.add(i);
                } else if (skill == 3) {
                    sportspeople.add(i);
                }
            }
            int w = Math.min(programmers.size(), Math.min(mathematicians.size(), sportspeople.size()));
            System.out.println(w);
            for (int i = 0; i < w; i++) {
                System.out.println(programmers.get(i) + " " + mathematicians.get(i) + " " + sportspeople.get(i));
            }
        }
    }
}