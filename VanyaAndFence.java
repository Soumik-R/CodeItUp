import java.util.Scanner;
public class VanyaAndFence {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int total = 0;

        for(int i=0; i<n; i++){
            int friendH = sc.nextInt();
            if(friendH>m){
                total+=2;
            }else{
                total+=1;
            }
        }
        System.out.println(total);
    }
}
