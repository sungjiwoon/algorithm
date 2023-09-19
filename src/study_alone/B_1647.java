package study_alone;

import java.io.*;
import java.util.*;

public class B_1647 {
    static int n, m;
    static int[][] graph;
    static int[] parent;
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (y < x) parent[x] = y;
        else parent[y] = x;
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    private static int solve() {

        Arrays.sort(graph, (o1,o2) -> o1[2] - o2[2]);
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int cost = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                cost += graph[i][2];
                max = Math.max(max, graph[i][2]);
            }
        }
        cost -= max;

        return cost;
    }
    private static int solvePrim() {
        int cost = 0;

        Arrays.sort(graph, (o1,o2) -> o1[2]-o2[2]);


        return cost;
    }
    public static void main(String[] args) {
        input();
        //System.out.println(solve());
        System.out.println(solvePrim());
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            graph = new int[m][3];
            parent = new int[n+1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                graph[i][0] = Integer.parseInt(st.nextToken());
                graph[i][1] = Integer.parseInt(st.nextToken());
                graph[i][2] = Integer.parseInt(st.nextToken());
            }
        } catch (Exception e){}
    }
}
