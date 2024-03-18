package hell_study;

import java.io.*;
import java.util.*;
/** 240318 백준 ACM Craft 골드 3 위상정렬 */
public class B_1005 {

    static int n, k, w;
    static int[] buildTime, seq;
    static List<Integer>[] graph;

    private static int solve() {

        int[] res = new int[n+1];
        Queue<Integer> pq = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (seq[i] == 0) {
                res[i] = buildTime[i];
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int p = pq.poll();
            for (int nxt : graph[p]) {
                res[nxt] = Math.max(res[nxt], res[p] + buildTime[nxt]);
                seq[nxt]--;
                if (seq[nxt] == 0) pq.add(nxt);
            }
        }

        return res[w];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(tz.nextToken());
            k = Integer.parseInt(tz.nextToken());

            buildTime = new int[n+1];
            graph = new ArrayList[n+1];
            seq = new int[n+1];
            tz = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                buildTime[i] = Integer.parseInt(tz.nextToken());
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < k; i++) {
                tz = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(tz.nextToken());
                int b = Integer.parseInt(tz.nextToken());
                graph[a].add(b);
                seq[b]++;
            }

            w = Integer.parseInt(br.readLine());
            sb.append(solve()+"\n");
        }
        System.out.println(sb);
    }
}
