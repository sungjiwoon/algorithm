package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_1707 {

    int v, e;
    List<Integer>[] graph;

    private boolean bfs(int idx, int[] colors) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(idx);
        colors[idx] = 1;

        while (!qu.isEmpty()) {
            int q = qu.poll();

            for (int nxt : graph[q]) {
                if (nxt != q && colors[nxt] == colors[q]) return false;
                if (colors[nxt] == 0) {
                    colors[nxt] = colors[q] * -1; // 1과 -1을 담음
                    qu.add(nxt);
                }
            }
        }
        return true;
    }

    private String solve() {
        // 정점 연결된 정점은 다른 색을 줌 > 만약 방문한 정점의 연결 정점이 색이 같은 색일 경우 이분그래프 X

        int[] colors = new int[v+1];
        for (int i = 1; i <= v; i++) {
            if (colors[i] != 0) continue;
            if (!bfs(i, colors)) return "NO";
        }
        return "YES";

    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());

            StringBuilder ans = new StringBuilder();
            for (int t = 0; t < T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                v = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());

                graph = new List[v+1];
                for (int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

                for (int i = 0; i < e; i++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    graph[b].add(a);
                    graph[a].add(b);
                }

                ans.append(solve()+"\n");
            }
            System.out.println(ans);

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1707 b = new B_1707();
        b.init();
    }
}
