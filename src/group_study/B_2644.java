package group_study;

import java.io.*;
import java.util.*;

public class B_2644 {
    static int n;
    static int p1, p2;
    static ArrayList<Integer>[] graph; //가족 구성도를 나타내는 관계도
    private static int bfs() {
        int[][] d = new int[n+1][n+1];
        boolean[] vis = new boolean[n+1];

        Queue<Integer> qu = new LinkedList<>();
        qu.add(p1);

        while (!qu.isEmpty()) {
            int p = qu.poll();
            vis[p] = true;

            for (int q : graph[p]) {
                if (q == p2) return d[p1][p]+1;
                if (vis[q]) continue;
                d[p1][q] = d[p1][p] + 1;
                qu.add(q);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }
    private static void input() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            graph = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            p1 = Integer.parseInt(st.nextToken());
            p2 = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                // x (부모) -> y (자식)
                // 양방향으로 넣어줘야하는 이유 : p1 p2 중 누가 더 조상이고 자손인지 모르기 때문에
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
