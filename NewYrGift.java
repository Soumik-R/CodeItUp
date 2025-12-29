import java.io.*;
import java.util.*;
public class NewYrGift {    
    static class Friend implements Comparable<Friend> {
        int id;
        int x, y, z;
        long cost;
        public Friend(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
            this.cost = (long)z - y;
        }
        public int compareTo(Friend other) {
            return Integer.compare(other.x, this.x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st;
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            int[] a = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Friend[] friends = new Friend[n];
            long sumY = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                friends[i] = new Friend(i, x, y, z);
                sumY += y;
            }
            long currK = k - sumY;
            if (currK < 0) {
                currK = 0;
            }
            Arrays.sort(friends);
            PriorityQueue<Long> AssCosts = new PriorityQueue<>();
            ArrayList<Long> PCosts = new ArrayList<>();
            int avlBox = 0;
            int boxPtr = m - 1;
            for (Friend f : friends) {
                while (boxPtr >= 0 && a[boxPtr] >= f.x) {
                    avlBox++;
                    boxPtr--;
                }
                AssCosts.add(f.cost);
                if (AssCosts.size() > avlBox) {
                    long evCost = AssCosts.poll();
                    PCosts.add(evCost);
                }
            }
            int happyCnt = AssCosts.size();
            Collections.sort(PCosts);
            for (long cost : PCosts) {
                if (currK >= cost) {
                    currK -= cost;
                    happyCnt++;
                } else {
                    break;
                }
            }
            out.println(happyCnt);
        }
        out.flush();
    }
}