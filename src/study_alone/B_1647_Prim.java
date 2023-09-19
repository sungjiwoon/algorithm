package study_alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_1647_Prim {
    static int n, m;
    static ArrayList<Integer>[] graph;
    static int[][] cost;
    private static int solve() {
        int res = 0;
        PriorityQueue<int[]> qu = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);

        int ni = 1;
        boolean[] vis = new boolean[n+1];
        vis[1] = true;
        int max = 0;
        for (int nxt : graph[1]) {
            qu.add(new int[]{1, nxt, cost[1][nxt]});
        }

        while (!qu.isEmpty() && ni <= n) {
            int[] q = qu.poll();
            if (vis[q[1]]) continue;
            vis[q[1]] = true;
            res += q[2];
            ni++;
            max = Math.max(q[2], max);
            for (int nxt : graph[q[1]]) {
                qu.add(new int[]{q[1], nxt, cost[q[1]][nxt]});
            }
        }

        return res - max;
    }
    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n+1];
            cost = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                graph[y].add(x);
                cost[x][y] = cost[y][x] = c;
            }
        } catch (Exception e){}
    }
}
