package study_alone;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class B_1504 {
    static ArrayList<Integer>[] graph;
    static int n, e;
    static long[][] d;
    static int v1,v2;
    static final int INF = Integer.MAX_VALUE;

    private static long solve(int st, int en) {
        //1 -> n 까지 최소 거리 구함.
        long ans = 0;

        PriorityQueue<Integer> qu = new PriorityQueue<>((o1, o2) -> (int)(d[st][o1] - d[st][o2]));
        qu.add(st);

        while (!qu.isEmpty()) {
            int q = qu.poll();

            for (int nxt : graph[q]) {
                if (d[st][nxt] < d[st][q] + d[q][nxt]) continue;
                d[st][nxt] = d[st][q] + d[q][nxt];
                qu.add(nxt);
            }
        }

        ans = d[st][en];
        return ans;
    }

    public static void main(String[] args) {
        input();

        long max = Math.min(solve(1,v1) + solve(v1,v2) + solve(v2,n),
                solve(1,v2)+solve(v2,v1)+solve(v1,n));
        if (max >= INF) max = -1;
        System.out.println(max);

    }

    private static void input() {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            e = Integer.parseInt(sp[1]);
            graph = new ArrayList[n+1];
            d = new long[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<Integer>();
                Arrays.fill(d[i], INF);
                d[i][i] = 0;
            }

            while (e-- > 0) {
                sp = br.readLine().split(" ");
                int a = Integer.parseInt(sp[0]);
                int b = Integer.parseInt(sp[1]);
                int c = Integer.parseInt(sp[2]);

                graph[a].add(b);
                graph[b].add(a);
                d[a][b] = d[b][a] = c;
            }

            sp = br.readLine().split(" ");
            v1 = Integer.parseInt(sp[0]);
            v2 = Integer.parseInt(sp[1]);

        } catch(Exception e) {}
    }
}
