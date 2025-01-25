package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/** 240125 사전 순 최대 공통 수열 그리디 https://www.acmicpc.net/problem/30805 */
public class B_30805 {
    int[] a, b;
    int n, m;

    void solve() {
        init();

        // o1[0] -> 값, o1[1] -> 인덱스 a, o1[2] -> 인덱스 b
        // 값은 내림차순, 인덱스는 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o2[0]-o1[0];
            if (o1[1] != o2[1]) return o1[1]-o2[1];
            return o1[2]-o2[2];
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    pq.add(new int[]{a[i], i, j});
                }
            }
        }

        Deque<int[]> qu = new LinkedList<>();
        boolean[] a_vis = new boolean[n];
        boolean[] b_vis = new boolean[m];

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int a_idx = p[1], b_idx = p[2];
            System.out.println("qu poll " + p[0] + " aIdx: " + a_idx+", bIdx: " + b_idx);
            if (a_vis[a_idx] || b_vis[b_idx]) continue;

            if (qu.isEmpty() || (qu.peekLast()[1] < a_idx && qu.peekLast()[2] < b_idx)) {
                // 더 뒤에 있으므로, 넣어도됨.
                qu.add(p);
                a_vis[a_idx] = true;
                b_vis[b_idx] = true;
            }
        }

        int k = qu.size();
        System.out.println(k);
        while (!qu.isEmpty()) {
            System.out.print(qu.poll()[0] + " ");
        }

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = Integer.parseInt(br.readLine());
            b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_30805 b = new B_30805();
        b.solve();
    }
}
