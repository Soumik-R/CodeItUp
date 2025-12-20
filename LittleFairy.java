import java.util.*;

public class LittleFairy {

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            
            while (t-- > 0) {
                int n = sc.nextInt(); 
                
                Set<Integer> dis = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    dis.add(sc.nextInt());
                }
                
                for (int i = 0; i < 2000; i++) {
                    int currCnt = dis.size();
                    
                    if (dis.contains(currCnt)) {
                        System.out.println(currCnt);
                        break;
                    }   
                    dis.add(currCnt);
                }
            }
        }
        sc.close();
    }
    
    public static void main(String[] args) {
        solve();
    }
}