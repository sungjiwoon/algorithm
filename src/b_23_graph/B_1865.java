package b_23_graph;
import java.io.*;
import java.util.*;

/** 240319 백준 웜홀 벨만포드 골드 3*/
public class B_1865 {

    static int n, m, w; // 지점 수, 도로 수, 웜홀 수
    static List<int[]>[] graph;

    private static String solve() {



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

            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                tz = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(tz.nextToken());
                int e = Integer.parseInt(tz.nextToken());
                int t = Integer.parseInt(tz.nextToken());
                graph[s].add(new int[]{e, t});
                graph[e].add(new int[]{s, t});
            }

            for (int i = 0; i < w; i++) {
                tz = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(tz.nextToken());
                int e = Integer.parseInt(tz.nextToken());
                int t = Integer.parseInt(tz.nextToken());
                graph[s].add(new int[]{e, t * (-1)});
            }

            sb.append(solve());
        }
        System.out.println(sb);

    }
}
