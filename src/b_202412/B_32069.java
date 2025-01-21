package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/** 240121 가로등 그리디 + BFS */
public class B_32069 {

    long l;
    int n, k;
    long[] arr;

    void solve() throws Exception {
        init();

        // BFS로 K개 까지 돈다
        // 방문 맵은 인덱스가 long이므로, 해시맵 형태로 확인한다.

        Map<Long, Boolean> vis = new HashMap<>();

        Queue<long[]> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            qu.add(new long[]{arr[i], 0L});
            vis.put(arr[i], true);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!qu.isEmpty()) {
            long[] q = qu.poll();
            sb.append(q[1]+"\n");
            cnt++;
            if (cnt == k) {
                break;
            }

            long q1 = q[0] + 1;
            if (q1 <= l && !vis.containsKey(q1)) {
                vis.put(q1, true);
                qu.add(new long[]{q1, q[1]+1L});
            }

            long q2 = q[0] - 1;
            if (q2 >= 0 && !vis.containsKey(q2)) {
                vis.put(q2, true);
                qu.add(new long[]{q2, q[1]+1L});
            }
        }
        System.out.println(sb);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] tmp = br.readLine().split(" ");
            l = Long.parseLong(tmp[0]);
            n = Integer.parseInt(tmp[1]);
            k = Integer.parseInt(tmp[2]);
            tmp = br.readLine().split(" ");
            arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(tmp[i]);
            }


        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_32069 b = new B_32069();
        b.solve();
    }
}
