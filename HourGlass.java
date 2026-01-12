import java.util.Scanner;
public class HourGlass {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int s = sc.nextInt();
                int k = sc.nextInt();
                int m = sc.nextInt();

                int q = m/k;
                int r = m%k;
                int ans;
                if(k>=s){
                    ans = Math.max(0, s-r);
                }else{
                    if(q%2 == 0){
                        ans = s - r;
                    }else{
                        ans = k - r;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
