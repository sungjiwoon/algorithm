package group_study;

import java.io.*;
import java.util.*;

/*
    로봇 청소기 (골5)
 */
public class B_14503 {
    static int n,m;
    static int r,c,dir;
    static int[][] map;
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int bfs() {
        int[][] d = new int[n][m];

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        //북, 동, 남, 서
        //반시계 : 북->서->남->동

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(r,c));

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            d[p.x][p.y] = 1; //d[i][j] = 1 : 청소한다

            int clean = 0;
            int dir_k = dir;
            for (int k = 0; k < 4; k++) {
                dir_k = (dir_k + 3) % 4; //반시계 방향
                int xx = p.x + dx[dir_k];
                int yy = p.y + dy[dir_k];

                if (xx < 0 || yy < 0 || xx >= n || yy >= m) continue;
                if (map[xx][yy] == 0 && d[xx][yy] == 0) {
                    //벽이 아니고, 청소도 안했을 경우.
                    qu.add(new Pair(xx,yy));
                    dir = dir_k;
                    break;
                }
                clean++; //청소 돼있음.

            }

            if (clean == 4) {
                int dir_b = (dir+2) % 4; //후진방향
                int xx = p.x + dx[dir_b];
                int yy = p.y + dy[dir_b];
                if (xx < 0 || yy < 0 || xx >= n || yy >= m) break;
                if (map[xx][yy] == 0) {
                    qu.add(new Pair(xx,yy));
                }
            }
        }

        return cnt_clean(d);
    }
    private static int cnt_clean(int[][] d) {
        //청소한 구역 찾기.
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j] == 1) res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }
    private static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
