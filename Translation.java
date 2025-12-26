import java.util.Scanner;
public class Translation {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        StringBuilder rev = new StringBuilder(s);
        String trev=  rev.reverse().toString();

        if(trev.equals(t)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
