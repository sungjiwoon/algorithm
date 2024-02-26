package hell_study;

import java.io.*;
import java.util.*;

/** 240226 백준 2667 단지 번호 붙이기 그래프 */

public class B_2667 {
    int n;
    char[][] map;
    int[][] vis;
    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private int bfs(int i, int j, int area) {
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        Deque<Pair> qu = new LinkedList<>();
        qu.add(new Pair(i, j));
        int cnt = 1;
        vis[i][j] = area;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int x = p.x, y = p.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (vis[nx][ny] == 0 && map[nx][ny] == '1') {
                    vis[nx][ny] = area;
                    qu.add(new Pair(nx, ny));
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private StringBuilder solve() {
        StringBuilder sb = new StringBuilder();

        vis = new int[n][n];
        int area = 1; //구역 번호
        List<Integer> cntList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && vis[i][j] == 0) {
                    cntList.add(bfs(i, j, area));
                    area++;
                }
            }
        }

        Collections.sort(cntList);

        sb.append(cntList.size() + "\n");
        for (int cnt : cntList) {
            sb.append(cnt + "\n");
        }

        return sb;
    }
    public static void main(String[] args) {
        B_2667 b = new B_2667();
//        Main b = new Main();
        b.input();
        System.out.println(b.solve());
    }
    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            map = new char[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }
        } catch (Exception e) {}
    }
}
