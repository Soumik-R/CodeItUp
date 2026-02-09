import java.util.*;
public class OddOut {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t = sc.nextInt();
            while(t-->0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                if(a==b){
                    System.out.println(c);
                }else if(a==c){
                    System.out.println(b);
                }else{
                    System.out.println(a);
                }
            }
        }
    }
}
