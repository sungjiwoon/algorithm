package hell_study;

import java.io.*;
import java.util.*;
/** 24024 헌내기는 친구가 필요해 실버 2 BFS */
public class B_21736 {
    private char[][] map;
    private int n, m;
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private Pair init() {
        // 도연이 찾아주는 함수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    return new Pair(i, j);
                }
            }
        }
        return null;
    }
    private String solve() {
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        int[][] vis = new int[n][m];
        int res = 0;

        Queue<Pair> qu = new LinkedList<>();
        qu.add(init());

        // BFS 구간

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            if (map[p.x][p.y] == 'P') {
                res++;
            }
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (vis[nx][ny] == 0 && map[nx][ny] != 'X') {
                    qu.add(new Pair(nx, ny));
                    vis[nx][ny] = 1;
                }
            }
        }

        if (res != 0) return String.valueOf(res);
        return "TT";
    }
    public static void main(String[] args) throws IOException {
        B_21736 b = new B_21736();
//        Main b = new Main();
        b.input();
        System.out.println(b.solve());
    }

    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }

}
