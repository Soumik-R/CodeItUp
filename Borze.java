import java.util.*;
public class Borze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                result.append('0');
            } else {
                if (s.charAt(i + 1) == '.') {
                    result.append('1');
                } else {
                    result.append('2');
                }
                i++;
            }
        }
        System.out.println(result);
    }
}