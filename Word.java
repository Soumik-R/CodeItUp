import java.util.Scanner;
public class Word {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int upperCount = 0;
        int lowerCount = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                upperCount++;
            }else{
                lowerCount++;
            }
        }
        if(upperCount>lowerCount){
            System.out.println(s.toUpperCase());
        }else{
            System.out.println(s.toLowerCase());
        }
    }
}
