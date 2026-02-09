import java.util.*;
public class MedianN {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t = sc.nextInt();
            while(t-->0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                int[] res = {a, b, c};
                Arrays.sort(res);
                System.out.println(res[1]);
            }
        }
    }
}
