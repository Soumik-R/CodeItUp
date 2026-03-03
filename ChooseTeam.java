import java.util.ArrayList;
import java.util.Scanner;
public class ChooseTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] students = new int[n];
            for (int i = 0; i < n; i++) {
                students[i] = sc.nextInt();
            }
            ArrayList<Integer> validStudents = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (students[i] + k <= 5) {
                    validStudents.add(students[i]);
                }
            }
            System.out.println(validStudents.size() / 3);
        }
    }
}