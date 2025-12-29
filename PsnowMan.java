import java.util.Scanner;
public class PsnowMan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                int[] b = new int[n];
                int[] c = new int[n];
                for(int i=0; i<n; i++) a[i] = sc.nextInt();
                for(int i=0; i<n; i++) b[i] = sc.nextInt();
                for(int i=0; i<n; i++) c[i] = sc.nextInt();                
                long cntAB = cntValid(n, a, b);
                long cntBC = cntValid(n, b, c);                
                long res = (long)n * cntAB * cntBC;
                System.out.println(res);
            }
        }
    }    
    private static long cntValid(int n, int[] arr1, int[] arr2) {
        long validCnt = 0;
        for (int shift = 0; shift < n; shift++) {
            boolean poss = true;
            for (int i = 0; i < n; i++) {
                if (arr1[i] >= arr2[(i + shift) % n]) {
                    poss = false;
                    break;
                }
            }
            if (poss) {
                validCnt++;
            }
        }
        return validCnt;
    }
}