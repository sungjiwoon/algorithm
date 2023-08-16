package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {
    static int n,m;
    static int[][] map, d;

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void bfs() {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(1,1));
        d[1][1] = 1;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            if (p.x == n && p.y == m) {
                return;
            }
            for (int k = 0; k < 4; k++) {
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if (xx <= 0 || xx > n || yy <= 0 || yy > m || map[xx][yy] == 0) continue;
                if (d[xx][yy] == 0) {
                    d[xx][yy] = d[p.x][p.y] + 1;
                    qu.add(new Pair(xx, yy));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(d[n][m]);
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[101][101];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        d = new int[101][101];

    }
}
