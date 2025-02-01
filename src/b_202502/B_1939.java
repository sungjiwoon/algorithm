package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 250201 중량제한 다익스트라 골드3
public class B_1939 {
    int n, m;
    int st, en;

    List<int[]>[] graph;


    void solve() {

        long[] cost = new long[n+1];
        Arrays.fill(cost, Integer.MIN_VALUE);

        cost[st] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        for (int[] nxt : graph[st]) {
            pq.add(nxt);
        }

        while (!pq.isEmpty()) {
            int[] q = pq.poll();
            int cq = q[1];
            if (cq < cost[q[0]]) continue; // 현재 cost로 갈수 있는 최댓값이 더 늘어남.
//            System.out.println(q[0] + " " + q[1]);
            for (int[] nxt: graph[q[0]]) {
                int nxtC = nxt[1];
                int d = Math.min(cq, nxtC);
                if (cost[nxt[0]] < d) {
                    cost[nxt[0]] = d;
                    pq.add(new int[] {nxt[0], d});
                }
            }
        }
        System.out.println(cost[en]);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(token.nextToken());
            m = Integer.parseInt(token.nextToken());

            graph = new List[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                int c = Integer.parseInt(token.nextToken());
                graph[a].add(new int[] {b, c});
                graph[b].add(new int[] {a, c});
            }

            token = new StringTokenizer(br.readLine(), " ");
            st = Integer.parseInt(token.nextToken());
            en = Integer.parseInt(token.nextToken());

            solve();
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_1939 b = new B_1939();
        b.init();

    }
}
