import java.util.Scanner;

public class Collatz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t>0) {
            int k = sc.nextInt();
            int initial = sc.nextInt();

            for (int i = 0; i < k; i++) {
                if (initial % 2 == 0) {
                    initial =initial* 2;
                } else {
                    if((initial-1) %3 == 0 && ((initial -1)/3) %2 ==1){
                        initial = (initial - 1) / 3;
                    }else{
                        initial = initial*2;
                    }
                }
            }

            System.out.println(initial);
            t--;
        }
    }
}
