import java.util.Scanner;
public class NearlyLucky {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int lucky = 0;
        for(int i=0; i<s.length(); i++){
            char digit = s.charAt(i);
            if(digit =='4' || digit == '7'){
                lucky++;
            }
        }
        if(lucky == 4 || lucky == 7){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
