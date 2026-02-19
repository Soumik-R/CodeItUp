import java.util.*;
public class Minimize {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t=  sc.nextInt();
            while(t-->0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(b-a);
            }
        }
    }
}
