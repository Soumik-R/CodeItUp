import java.util.*;
public class BlackSq {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int[] calories = new int[4];
        for(int i=0; i<4; i++){
            calories[i]  =sc.nextInt();
        }
        String s = sc.next();
        int ttlCal = 0;
        for(int i=0; i<s.length(); i++){
            char currStrp = s.charAt(i);
            int idx =  currStrp-'1';
            ttlCal += calories[idx];
        }
        System.out.println(ttlCal);
    }
}
