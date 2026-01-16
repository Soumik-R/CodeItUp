package Java;
import java.util.*;
public class YorY {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            if(s.equalsIgnoreCase("YES")){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
