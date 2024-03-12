package hell_study;

import java.io.*;
import java.util.*;
/** 240312 백준 1325 효율적인 해킹 DFS */
public class B_1325 {
    static int n;
    static int[] cnt;
    static boolean[] vis;
    static List<Integer>[] graph;

    private static void dfs(int idx) {
        vis[idx] = true;

        // idx 에 연결된 컴퓨터들을 찾는다.
        for (int nxt : graph[idx]) {
            if (vis[nxt]) {
                continue;
            }
            cnt[idx]++;
            dfs(nxt);
//            System.out.println(String.format("nxt : %d, cnt[%d] = %d", nxt, idx, cnt[idx]));
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        Map<Integer, List<Integer>> resMap = new HashMap<>();
        int max = n + 1;

        for (int i = 1; i <= n; i++) {
            vis = new boolean[n+1];
            dfs(i);

            System.out.println(String.format("cnt[%d] = %d", i, cnt[i]));

            List<Integer> get = resMap.getOrDefault(cnt[i], new ArrayList<>());
            get.add(i);
            resMap.put(cnt[i], get);
            max = Math.min(max, cnt[i]);
        }

        List<Integer> maxList = resMap.get(max);
        Collections.sort(maxList);
        for (int x : maxList) {
            System.out.print(x + " ");
        }

    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        cnt = new int[n+1];
        vis = new boolean[n+1];
    }
}
