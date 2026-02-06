import java.util.*;
public class SpyD {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t = sc.nextInt();
            while(t-->0){
                int n = sc.nextInt();
                int a[] = new int[n];
                for(int i=0; i<n;i++){
                    a[i] = sc.nextInt();
                }
                boolean firstS = (a[0] != a[1] && a[0] != a[2]);
                if(firstS){
                    System.out.println(1);
                }
                else{
                    for(int i=1;i<n; i++){
                        if(a[i]!=a[0]){
                            System.out.println(i+1);
                            break;
                        }
                    }
                }
            }
        }
    }
}
