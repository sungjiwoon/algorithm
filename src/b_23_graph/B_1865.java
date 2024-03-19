package b_23_graph;
import java.io.*;
import java.util.*;

/** 240319 백준 웜홀 벨만포드 골드 3*/
public class B_1865 {

    static int n, m, w; // 지점 수, 도로 수, 웜홀 수
    static List<int[]> graph;
    static final long INF = Integer.MAX_VALUE;

    private static String solve() {

        for (int i = 1; i <= n; i++) {
            // 모든 지점을 전부 출발지점이라고 생각한다.
            long[] d = new long[n+1];
            Arrays.fill(d, INF);
            d[i] = 0;

            boolean ok = false;

            for (int j = 1; j <= n; j++) {
                ok = false;
                for (int[] edge : graph) {
                    if (d[edge[0]] != INF && d[edge[1]] > d[edge[0]] + edge[2]) {
                        d[edge[1]] = d[edge[0]] + edge[2];
                        ok = true;
                        if (j == n) {
                            // 마지막 까지 값이 변한다면 음수가 있는 것이다. 그러면 시간이 줄어든간 뜻이므로 YES를 반환.
                            return "YES\n";
                        }
                    }
                }

                // 단 한개도 정점에 연결된 그래프가 없는 경우 -> 굳이 웜홀 찾을 필요도 없이 break -> 시간 초과 대비
                if (!ok) break;
            }
        }


        return "NO\n";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(tz.nextToken());
            m = Integer.parseInt(tz.nextToken());
            w = Integer.parseInt(tz.nextToken());

            graph = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                tz = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(tz.nextToken());
                int e = Integer.parseInt(tz.nextToken());
                int t = Integer.parseInt(tz.nextToken());
                graph.add(new int[]{s, e, t});
                graph.add(new int[]{e, s, t});
            }

            for (int i = 0; i < w; i++) {
                tz = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(tz.nextToken());
                int e = Integer.parseInt(tz.nextToken());
                int t = Integer.parseInt(tz.nextToken());
                graph.add(new int[]{s, e, t * (-1)});
            }

            sb.append(solve());
        }
        System.out.println(sb);

    }
}
