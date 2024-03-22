package b_28_dijkstra;

import java.io.*;
import java.util.*;
/** 240322 백준 발전소 다익스트라 골드 4 */
public class B_1277 {

    static final Double INF = 200001.0;
    static int n, w;
    static double m;
    static boolean[][] connect;
    static int[][] map;

    private static double getDist(int a, int b) {
        if (connect[a][b]) return 0.0;
        int x1 = map[a][0], y1 = map[a][1];
        int x2 = map[b][0], y2 = map[b][1];
        // 피타고라스 정리
        double d = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
        return Math.sqrt(d);
    }

    private static long solve() {


        //다익스트라
        boolean[] vis = new boolean[n+1];
        //연결된 정점이 있다면 true (갈수 있는 방법이 있다면)

        double[] d = new double[n+1];
        Arrays.fill(d, INF);

        d[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (connect[1][i]) d[i] = 0;
        }


        for (int i = 1; i <= n; i++) {
            double minD = INF;
            int cur = 0;
            for (int j = 1; j <= n; j++) {
                // 해당 정점과 연결된 최단 정점 찾기.
                if (!vis[j] && minD >= d[j]) {
                    minD = d[j];
                    cur = j;
                }
            }

            if (cur == n) break;
            vis[cur] = true;

            for (int j = 1; j <= n; j++) {
                if (j == cur) continue;
                double nxtD = getDist(j, cur);
                if (nxtD > m) continue;

                if (d[j] > d[cur] + nxtD) {
                    d[j] = d[cur] + nxtD;
                }
            }
        }


        return (long) (d[n] * 1000);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        m = Double.parseDouble(br.readLine());

        map = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }


        connect = new boolean[n+1][n+1];
        int a, b;
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            connect[a][b] = connect[b][a] = true;
        }

        System.out.println(solve());

    }
}
