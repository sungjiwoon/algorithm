package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/** 240125 전생했더니 슬라임 연구자였던 건에 대하여 (Hard) 그리디 */
public class B_14698 {
    long[] c;
    int n;
    final int INF = 1000000007;

    void solve(StringBuilder sb) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(c[i]);
        }

        long v = 1;
        while (pq.size() > 1) {
            long p = pq.poll();
            long q = pq.poll();

            long mul = (p * q);
            pq.add(mul);

            v *= (mul % INF);
            v %= INF;
        }
        sb.append(v + "\n");

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < T; t++) {
                n = Integer.parseInt(br.readLine());
                c = new long[n];
                String[] sp = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    c[i] = Long.parseLong(sp[i]);
                }
                solve(sb);
            }
            System.out.println(sb);
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_14698 b = new B_14698();
        b.init();
    }
}
