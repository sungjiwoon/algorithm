package b_28_dijkstra;

import java.io.*;
import java.util.*;
/** 240322 백준 해킹 골드 4 다익스트라 */
public class B_10282 {
    static int n, d, c;
    static List<int[]>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    private static String solve() {
        String res = "";

        dist[c] = 0; // 시작 정점.
        boolean[] vis = new boolean[n+1];


        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[1] - o2[1]
        );

        pq.add(new int[]{c, 0});
        while (!pq.isEmpty()) {
            int[] q = pq.poll();
            if (dist[q[0]] != q[1]) continue;
            if (vis[q[0]]) continue;
            vis[q[0]] = true;

            for (int[] nxt : graph[q[0]]) {
                if (dist[nxt[0]] < dist[q[0]] + nxt[1]) continue;
                dist[nxt[0]] = dist[q[0]] + nxt[1];
                pq.add(new int[]{nxt[0], dist[nxt[0]]});
            }
        }

        int cnt = 0;
        long time = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != INF) {
                cnt++;
                time = Math.max(time, dist[i]);
            }
        }

        return cnt + " " + time + "\n";
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            dist = new int[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
                dist[i] = INF;
            }

            int a, b, s;
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }
            sb.append(solve());
        }

        System.out.println(sb);
    }
}
