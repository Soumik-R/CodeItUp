import java.util.*;
public class Icpc {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            int t = sc.nextInt();
            while(t-->0){
                int n = sc.nextInt();
                String s = sc.next();
                HashMap<Character, Boolean> mpp = new HashMap<>();
                int ttl = 0;
                for(int i=0; i<n; i++){
                    char prblm = s.charAt(i);
                    if(mpp.containsKey(prblm)){
                        ttl+=1;
                    }else{
                        ttl+=2;
                        mpp.put(prblm, true);
                    }
                }
                System.out.println(ttl);
            }
        }
    }
}
