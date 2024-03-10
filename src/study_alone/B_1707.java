package study_alone;

import java.io.*;
import java.util.*;
/** 240310 백준 이분 그래프 골드4 */
/*

이분 그래프 : 정점을 2그룹으로 나눌 수 있으되 같은 그룹의 정점끼리는 간선으로 이어지지 않은 경우
1. 최초 탐색 시작할 정점의 색상을 빨간색으로 칠한다.(숫자 1로 표현)
2. 최초 정점의 인접 정점의 색상을 파란색으로 칠한다.(숫자 -1로 표현)
3. 해당 인접 정점들을 차례로 탐색을 시작하며 자신과 인접한 정점을 빨간색으로 칠한다.(숫자 1로 표현)
4. 이와 같은 방식을 탐색을 지속하며 반복하여 2개의 색상으로 모두 칠한다.
5. 색상을 칠하다가 이웃 정점이 같은 색으로 칠해져 있다면 이분 그래프가 될 수 없다.
 */
public class B_1707 {

    static List<Integer>[] graph;
    static int[] colors;
    static boolean isGraph;

    public static void dfs(int v, int color) {
        colors[v] = color;

        for (int nxt : graph[v]) {
            // 색상이 같다면 false
            if (colors[nxt] == colors[v]) {
                System.out.println(String.format("colors[%d] = colors[%d]", nxt, v));
                isGraph = false;
                return;
            }

            // 아직 방문하지 않았다면 dfs
            if (colors[nxt] == 0) {
                dfs(nxt, color * (-1));
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(tokenizer.nextToken());
            int E = Integer.parseInt(tokenizer.nextToken());

            graph = new ArrayList[V + 1];
            colors = new int[V + 1];
            for (int v = 1; v <= V; v++) graph[v] = new ArrayList<>();

            for (int e = 0; e < E; e++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            isGraph = true;
            for (int v = 1; v <= V; v++) {
                if (colors[v] != 0) continue; // 이미 한번 확인한 정점들은 확인 필요 X
                dfs(v, 1);
                if (!isGraph) break;
            }

            if (!isGraph) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }
        System.out.println(sb);
    }
}
