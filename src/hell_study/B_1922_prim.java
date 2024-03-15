package hell_study;

import java.io.*;
import java.util.*;

/** 240315 백준 1922 네트워크 연결 prim */

/*
프림 : 반복문 돌면서 모든 정점을 방문했는지 확인하는 방법
 */
public class B_1922_prim {

    class Edge {
        int v;
        int cost;
        Edge (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    int n;
    List<Edge>[] graph;

    private int solve() {

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        //정점 1부터 시작
        for (Edge e : graph[1]) {
            pq.add(e);
        }

        int res = 0;
        int cntV = 1;
        boolean[] vis = new boolean[n+1];
        vis[1] = true;

        while (cntV != n) {
            Edge e = pq.poll();
            while (vis[e.v]) e = pq.poll();

            res += e.cost;
            cntV++;
            vis[e.v] = true;
            for (Edge nxt : graph[e.v]) {
                if (vis[nxt.v]) continue;
                pq.add(nxt);
            }
        }

        return res;

    }
    public static void main(String[] args) {

        B_1922_prim b = new B_1922_prim();
//        Main b = new Main();

        b.input();
        System.out.println(b.solve());

    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph[arr[0]].add(new Edge(arr[1], arr[2]));
                graph[arr[1]].add(new Edge(arr[0], arr[2]));
            }


        } catch (Exception e) {}
    }
}
