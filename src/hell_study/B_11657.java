package hell_study;

import java.io.*;
import java.util.*;

/** 240314 백준 11657 타임머신, 벨만포드 알고리즘 공부 */

/*
엣지는 1->2, 4->2, 2->3, 3->4 순으로 입력되었다고 가정
dist[1~4] = [0, ∞, ∞, ∞]로 초기화 후 시작
모든 엣지를 방문하며 각각의 엣지 방문으로 인해 발생하는 최소값으로 갱신

1번 loop
1 -> 2 엣지 방문 -> 이 엣지로 인해 dist[2] = dist[1] + 1 = 1로 갱신
4 -> 2 엣지 방문 -> dist[4] = ∞이므로 갱신 X
2 -> 3 엣지 방문 -> 이 엣지로 인해 dist[3] = dist[2] + 1 = 2
3->4 엣지 방문 -> 이 엣지로 인해 dist[4] = dist[3] + 2 = 4
루프 종료 시 dist = [0, 1, 2, 4]

2번 loop
1 -> 2 엣지 방문 -> dist[2] == dist[1] + 1 이므로 갱신 X
4 -> 2 엣지 방문 -> 이 엣지로 인해 dist[2] = dist[4] - 5 = -1
2->3 엣지 방문 -> 이 엣지로 인해 dist[3] = dist[2] + 1 = 0
3->4 엣지 방문 -> 이 엣지로 인해 dist[4] = dist[3] + 2 = 2
루프 종료 시 dist = [0, -1, 0, 2]

3번 loop도 마찬가지로 실행하면 루프 종료 시 dist = [0, -3, -2, 0]
n - 1번의 loop 완료
만약 음의 사이클이 없다면 이때의 dist 값이 노드 1에서 모든 노드들까지의 최소 거리
하지만 음의 사이클이 있다면 사이클을 돌때마다 dist값이 계속 갱신될 것임
따라서 n-1번의 loop 후 loop를 한번 더 돌리고, 갱신값이 하나라도 존재하면 음의 사이클이 존재함을 알 수 있음
 */
public class B_11657 {
    int n;
    List<int[]> graph;
    final long INF = Long.MAX_VALUE;

    private StringBuilder solve() {

        StringBuilder sb = new StringBuilder();

        // 벨만 포드 알고리즘
        // 시작 정점 : 1
        long[] d = new long[n+1]; // 1번 정점에서 n번 정점까지 최단 거리
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 1; i <= n; i++) {
            for (int[] edge : graph) {
                if (d[edge[0]] != INF && d[edge[1]] > d[edge[0]] + edge[2]) {
                    d[edge[1]] = d[edge[0]] + edge[2];
                    if (i == n) {
                        sb.append("-1");
                        return sb;
                    }
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (d[i] == INF) sb.append("-1\n");
            else sb.append(d[i]+"\n");
        }

        return sb;

    }
    public static void main(String[] args) {
        B_11657 b = new B_11657();
        b.input();
        System.out.println(b.solve());
    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken()); //시작 정점
                int b = Integer.parseInt(st.nextToken()); //종료 정점
                int c = Integer.parseInt(st.nextToken()); //값
                graph.add(new int[]{a, b, c});
            }
        } catch (Exception e) {}
    }
}
