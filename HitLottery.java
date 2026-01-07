import java.util.*;
public class HitLottery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int[] bills = {100, 20, 10, 5, 1};
        long cnt = 0;
        for (int bill : bills) {
            cnt += n / bill;
            n %= bill;
        }
        System.out.println(cnt);
    }
}
