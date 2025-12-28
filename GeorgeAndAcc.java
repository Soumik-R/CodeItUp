import java.util.Scanner;
public class GeorgeAndAcc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int n = sc.nextInt();
        int vRooms = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt(); 
            int q = sc.nextInt();            
            if (q - p >= 2) {
                vRooms++;
            }
        }
        System.out.println(vRooms);        
    }
}