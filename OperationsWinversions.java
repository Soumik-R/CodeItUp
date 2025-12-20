import java.util.*;
public class OperationsWinversions {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t--> 0){
            int n = sc.nextInt();
            int[] a = new int[n];

            for(int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }

            int prefMax = 0;
            int mx = Integer.MIN_VALUE;

            for(int x: a){
                if(x>=mx){
                    prefMax++;
                    mx = x;
                }
            }
            System.out.println(n - prefMax);
        }
    }
}
