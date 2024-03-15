package hell_study;

import java.io.*;
import java.util.*;

/** 240315 백준 1922 네트워크 연결 크루스칼 (유니온파인드) */
public class B_1922_unionfind {

    int n;
    int[][] graph;
    int[] parent;

    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) parent[x] = y;
        else parent[y] = x;
    }

    private int solve() {
        int res = 0;

        // 간선을 최소 비용 기준으로 정렬한다.
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : graph) {
            if (find(edge[0]) != find(edge[1])) {
                //만약 간선이 서로 연결되어 있지 않는다면 부모는 다를 것이다.
                union(edge[0], edge[1]);
                res += edge[2];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        B_1922_unionfind b = new B_1922_unionfind();
//        Main b = new Main();

        b.input();
        System.out.println(b.solve());


    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            graph = new int[m][3];
            for (int i = 0; i < m; i++) {
                graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            parent = new int[n+1];

        } catch (Exception e) {}
    }
}
