package b_202410;

import java.io.*;
import java.util.*;

/** 241015 화
 * 저울 : 각 정점마다 연결된 간선의 갯수를 확인 및 더해준다.
 */

public class B_10159 {

    List<Integer>[] graph = new ArrayList[101];
    int[] values = new int[101];
    int n, m;

    public void dfs(int root, int x, boolean[] vis) {
        values[x]++;
        if (graph[x].size() == 0) {
            return;
        }

        for (int nxt : graph[x]) {
            if (vis[nxt]) continue;
            vis[nxt] = true;
            values[root]++; // root는 항상 +를 해줘야한다. 간선의 방향은 하나이기 때문에
            dfs(root, nxt, vis);
        }

    }

    public void solve() {
        for (int i = 1; i <= n; i++) {
            boolean[] vis = new boolean[101];
            vis[i] = true;
            dfs(i, i, vis);
        }

        for (int i = 1; i <= n; i++) {
            System.out.println((n-values[i]));
        }
    }

    public static void main(String[] args) throws Exception {
        B_10159 b= new B_10159();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            graph[tmp[0]].add(tmp[1]);
        }
    }
}
