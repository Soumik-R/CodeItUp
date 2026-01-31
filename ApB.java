import java.util.*;
public class ApB {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t = sc.nextInt();
            while(t-->0){
                int n = sc.nextInt();
                int tens = n/10;
                int ones = n%10;
                System.out.println(tens + ones);
            }
        }
    }
}
