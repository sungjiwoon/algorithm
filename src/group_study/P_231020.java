package group_study;
import java.util.*;

public class P_231020 {
    int n, m;
    char[][] map;
    final char 시작지점 = 'S', 출구 = 'E', 레버 = 'L', 벽 = 'X';
    final int 못감 = -1;

    class 좌표 {
        int x, y;
        좌표 (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public 좌표 getStart(char 시작점) {
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 시작점) {
                    return new 좌표(i, j);
                }
            }
        }
        return new 좌표(-1, -1);
    }

    public int bfs(좌표 시작좌표, char 목표지점) {
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        Queue<좌표> qu = new LinkedList<>();
        qu.add(시작좌표);

        int[][] d = new int[n][m];

        while (!qu.isEmpty()) {
            좌표 p = qu.poll();
            if (map[p.x][p.y] == 목표지점) {
                return d[p.x][p.y];
            }
            for (int k = 0; k < 4; k++) {
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if (xx<0 || yy<0 || xx>=n || yy>=m) continue;
                if (d[xx][yy] == 0 && map[xx][yy] != 벽) {
                    d[xx][yy] = d[p.x][p.y] + 1;
                    qu.add(new 좌표(xx, yy));
                }
            }
        }

        return 못감;
    }
    public int solution(String[] maps) {
        //레버를 간 다음에 도착지까지 가야하므로,
        //출발지 -> 레버 // 레버 -> 도착지까지의 최단거리를 각각 구해 더한다.

        n = maps.length;
        m = maps[0].length();

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        //출발지 -> 레버
        int 레버까지 = bfs(getStart(시작지점), 레버);
        if (레버까지 == 못감) return 못감;

        //레버 -> 도착지
        int 도착지까지 = bfs(getStart(레버), 출구);
        if (도착지까지 == 못감) return 못감;


        return 레버까지 + 도착지까지;
    }
}
