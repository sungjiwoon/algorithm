package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_13913 {
    int n, k;
    final int N = 100002;

    void solve() {
        init();
        int[] dx = {2, 1, -1};

        int[] prev = new int[N];
        int[] d = new int[N];
        Arrays.fill(d, N);
        d[n] = 0;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(n); // 수빈이 위치
        while (!qu.isEmpty()) {
            int x = qu.poll();
            if (x == k) break;
            for (int i = 0; i < 3; i++) {
                int nx = x;
                if (dx[i] != 2) nx += dx[i];
                else nx *= 2;
                if (nx < 0 || nx >= N) continue;
                if (d[nx] > d[x] + 1) {
                    d[nx] = d[x]+1;
                    prev[nx] = x;
                    qu.add(nx);
                }
            }
        }

        System.out.println(d[k]);
        int x = k;
        StringBuilder sb = new StringBuilder();
        sb.append(k + " ");
        while (x != n) {
            sb.insert(0,prev[x] + " ");
            x = prev[x];
        }
        System.out.println(sb);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            k = Integer.parseInt(sp[1]);

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_13913 b = new B_13913();
        b.solve();
    }
}
