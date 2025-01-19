package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// 240119 콘센트 그리디 https://www.acmicpc.net/problem/23843
public class B_23843 {

    int n, m;
    long[] times;


    private void solve() {
        init();

        Arrays.sort(times);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            if (n-1-i < 0) break;
            pq.add(times[n-1-i]);
        }


        for (int i = n-m-1; i >= 0; i--) {
            long p = pq.poll();
            pq.add(p + times[i]);
        }

        long res = 0;
        while (!pq.isEmpty()) {
            res = pq.poll();
        }
        System.out.println(res);


    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);

            times = Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();


        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_23843 b = new B_23843();
        b.solve();
    }
}
