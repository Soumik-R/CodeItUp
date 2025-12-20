import java.util.Scanner;

public class SleepingClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                String s = sc.next();
                
                int slpC = 0;
                int wakeIn = -1; 
                
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        wakeIn = Math.max(wakeIn, i + k);
                        
                    } else {
                        
                        if (i > wakeIn) {
                            slpC++;
                        }
                    }
                }
                
                System.out.println(slpC);
            }
        }
        sc.close();
    }
}