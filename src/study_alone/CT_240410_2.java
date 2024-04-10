package study_alone;
import java.io.*;
import java.util.*;

/** 240410 삼성 코드트리 빵 골드 2 구현 + BFS */

public class CT_240410_2 {
    final int INF = Integer.MAX_VALUE;
    final int N = 16;
    final int M = 31;

    int n, m;
    int[][] grid = new int[N][N];
    Pair[] cvsList = new Pair[M]; // 편의점 목록
    Pair[] people = new Pair[M]; // 사람들 위치 관리
    boolean[] isArrive = new boolean[M];
    int curT = 0; // 현재 시간

    int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    int[][] step = new int[N][N];
    boolean[][] vis = new boolean[N][N];

    public boolean isRange(int x, int y) {
        return 0 < x && x <= n && 0 < y && y <= n;
    }

    public boolean canGo(int x, int y) {
        return isRange(x, y) && !vis[x][y] && grid[x][y] != 2;
    }

    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs(Pair st) {
        vis = new boolean[N][N];
        step = new int[N][N];

        Queue<Pair> qu = new LinkedList<>();
        int sx = st.x, sy = st.y;
        qu.add(new Pair(sx, sy));
        vis[sx][sy] = true;
        step[sx][sy] = 0;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            int x = p.x, y = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (canGo(nx, ny)) {
                    vis[nx][ny] = true;
                    step[nx][ny] = step[x][y]+1;
                    qu.add(new Pair(nx, ny));
                }
            }
        }
    }

    public void move() {
        // 격자 안에 있는 사람들에 한하여 편의점으로 1칸 이동.
        for (int i = 1; i <= m; i++) {
            if (people[i] == null || isArrive[i]) continue;

            // 편의점 위치에서 BFS 해야, 최단거리 구할 수 있음.
            bfs(cvsList[i]);

            int px = people[i].x, py = people[i].y;
            int minD = INF;
            int minX = -1, minY = -1;
            for (int k = 0; k < 4; k++) {
                int nx = px + dx[k], ny = py + dy[k];
                if (isRange(nx, ny) && vis[nx][ny] && minD > step[nx][ny]) {
                    minD = step[nx][ny];
                    minX = nx;
                    minY = ny;
                }
            }

            people[i] = new Pair(minX, minY);
        }

        // 편의점에 도착한 사람들에 한하여 앞으로 이동 불가능하다고 표시.
        for (int i = 1; i <= m; i++) {
            if (people[i] == null) continue;
            int x = cvsList[i].x, y = cvsList[i].y;
            int px = people[i].x, py = people[i].y;
            if (x == px && y == py) {
                grid[x][y] = 2;
                isArrive[i] = true;
            }
        }

        // 베이스 캠프 이동.
        if (curT > m) return;
        bfs(cvsList[curT]);
        int minD = INF;
        int minX = -1, minY = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (vis[i][j] && grid[i][j] == 1 && minD > step[i][j]) {
                    minD = step[i][j];
                    minX = i;
                    minY = j;
                }
            }
        }

        people[curT] = new Pair(minX, minY);
        grid[minX][minY] = 2;

    }

    public boolean finish() {
        for (int i = 1; i <= m; i++) {
            if (!isArrive[i]) return false;
        }
        return true;
    }


    public void solve() {
        while (true) {
            curT++;
            move();
            if (finish()) break;
        }
        System.out.println(curT);
    }


    public static void main(String[] args) throws Exception {
        CT_240410_2 m = new CT_240410_2();
        m.init();
        m.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cvsList[i] = new Pair(x, y);
        }

    }
}

