package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/** 240123 파일합치기3 그리디 */
public class B_13975 {

    int T;
    int k;
    long[] files;
    void calculate(StringBuilder sb) {

        PriorityQueue<Long> qu = new PriorityQueue<>(); // 임시 파일 저장소
        for (int i = 0; i < k; i++) {
            qu.add(files[i]);
        }
        long sum = 0L;

        while (!qu.isEmpty()) {
            long q = qu.poll();
            if (qu.isEmpty()) { //맨 마지막은 더해줄 필요 X
                break;
            }
            sum += (q + qu.peek());
            qu.add(q + qu.poll());
        }

        sb.append(sum+"\n");
    }
    void solve() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < T; t++) {
                k = Integer.parseInt(br.readLine());
                String[] sp = br.readLine().split(" ");
                files = new long[k];
                for (int i = 0; i < k; i++) {
                    files[i] = Long.parseLong(sp[i]);
                }
                calculate(sb);
            }
            System.out.println(sb);

        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_13975 b= new B_13975();
        b.solve();
    }
}
