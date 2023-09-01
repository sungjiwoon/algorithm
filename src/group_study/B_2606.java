package group_study;
import java.io.*;
import java.util.*;

public class B_2606 {
    static int n,m;
    static ArrayList<Integer>[] graph;
    static boolean[] vis = new boolean[101];
    static int res = 0;
    private static void dfs(int now) {
        res++;
        vis[now] = true;
        for (int nxt : graph[now]) {
            if (vis[nxt]) continue;
            dfs(nxt);
        }
    }
    public static void main(String[] args) throws Exception {
        input();

        //dfs 수행 먼저
        dfs(1);
        System.out.println(res-1);
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList();
            }

            while (m-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
        } catch (Exception e) {

        }
    }
}
