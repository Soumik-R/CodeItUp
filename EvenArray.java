import java.util.*;
public class EvenArray {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t = sc.nextInt();
            while(t-->0){
                int n = sc.nextInt();
                int a[] = new int[n];

                int evIdx = 0;
                int odIdx = 0;
                for(int i=0;i<n;i++){
                    a[i] = sc.nextInt();
                    if(i%2 != a[i]%2){
                        if(i%2==0){
                            evIdx++;
                        }else{
                            odIdx++;
                        }
                    }
                }
                if(evIdx == odIdx){
                    System.out.println(evIdx);
                }else{
                    System.out.println("-1");
                }
            }
        }
    }
}
