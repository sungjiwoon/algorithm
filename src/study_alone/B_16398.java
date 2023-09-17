package study_alone;
import java.io.*;
import java.util.*;

public class B_16398 {
    static int n, k;
    static int[][] graph;
    static int[] parent;
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) parent[x] = y;
        else parent[y] = x;
    }
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void main(String[] args) {
        input();

        Arrays.sort(graph, (o1,o2) -> o1[2] - o2[2]);
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int cost = 0;
        for (int i = 0; i < k; i++) {
            if (find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                cost += graph[i][2];
            }
        }

        System.out.println(cost);
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            graph = new int[n*n][3];
            k = 0;
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= n; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    if (i == j) continue;
                    graph[k][0] = i;
                    graph[k][1] = j;
                    graph[k++][2] = v;
                }
            }
            parent = new int[n+1];
        } catch (Exception e) {}
    }
}
