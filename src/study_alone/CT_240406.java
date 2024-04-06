package study_alone;
import java.io.*;
import java.util.*;

/** 240406 코드트리 냉방 시스템 플레 5 빡빡빡빡구현 */
public class CT_240406 {
    final int MAX_N = 21;
    final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
    int n, m, k;
    int[][] map = new int[MAX_N][MAX_N];
    boolean[][][] wall = new boolean[MAX_N][MAX_N][2];
    List<Aircon> airconList = new ArrayList<>();
    List<Samosil> samosilList = new ArrayList<>();
    int sx, sy;

    class Aircon {
        int x, y, dir;
        Aircon(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    class Samosil {
        int x, y;
        Samosil(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void blowUp(int ax, int ay) {
        sx = ax-1;
        sy = ay;
        boolean[][] vis = new boolean[MAX_N][MAX_N];
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{sx, sy, 5});

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], power = q[2];
            map[x][y] += power;

            if (power == 1) continue;

            int nx = x-1, ny = y-1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][y][LEFT] && !wall[x][ny][UP]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            ny = y+1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][ny][LEFT] && !wall[x][ny][UP]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            ny = y;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][y][UP]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

        }

    }

    public void blowDown(int ax, int ay) {
        sx = ax + 1;
        sy = ay;
        boolean[][] vis = new boolean[MAX_N][MAX_N];
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{sx, sy, 5});

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], power = q[2];
            map[x][y] += power;

            if (power == 1) continue;

            int nx = x+1, ny = y-1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][y][LEFT] && !wall[nx][ny][UP]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            ny = y+1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][ny][LEFT] && !wall[nx][ny][UP]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            ny = y;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][ny][UP]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

        }
    }

    public void blowLeft(int ax, int ay) {
        sx = ax;
        sy = ay - 1;
        boolean[][] vis = new boolean[MAX_N][MAX_N];
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{sx, sy, 5});

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], power = q[2];
            map[x][y] += power;

            if (power == 1) continue;

            int nx = x-1, ny = y-1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][y][UP] && !wall[nx][y][LEFT]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            nx = x+1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[nx][y][UP] && !wall[nx][y][LEFT]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            nx = x;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][y][LEFT]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }
        }
    }

    public void blowRight(int ax, int ay) {
        sx = ax;
        sy = ay + 1;
        boolean[][] vis = new boolean[MAX_N][MAX_N];
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{sx, sy, 5});

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], power = q[2];
            map[x][y] += power;

            if (power == 1) continue;

            int nx = x-1, ny = y+1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[x][y][UP] && !wall[nx][ny][LEFT]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            nx = x+1;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[nx][y][UP] && !wall[nx][ny][LEFT]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }

            nx = x;
            if (isRange(nx, ny) && !vis[nx][ny] && !wall[nx][ny][LEFT]) {
                qu.add(new int[]{nx, ny, power-1});
                vis[nx][ny] = true;
            }
        }
    }

    public void blow() {
        for (Aircon a : airconList) {
            if (a.dir == 2) {
                blowLeft(a.x, a.y);
            } else if (a.dir == 3) {
                blowUp(a.x, a.y);
            } else if (a.dir == 4) {
                blowRight(a.x, a.y);
            } else {
                blowDown(a.x, a.y);
            }
        }
    }

    public boolean isRange(int x, int y) {
        return (x >= 1 && y >= 1 && x <= n && y <= n);
    }

    public void mixed() {
        int[][] plusMap = new int[MAX_N][MAX_N];
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int d = 0; d < 4; d++) {
                    int cx = i + dx[d], cy = j + dy[d];
                    if (isRange(cx, cy) && map[i][j] > map[cx][cy]) {
                        if (d == UP && wall[i][j][UP]) continue;
                        if (d == LEFT && wall[i][j][LEFT]) continue;
                        if (d == DOWN && wall[cx][cy][UP]) continue;
                        if (d == RIGHT && wall[cx][cy][LEFT]) continue;
                        int pp = (map[i][j] - map[cx][cy]) / 4;
                        plusMap[i][j] -= pp;
                        plusMap[cx][cy] += pp;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] += plusMap[i][j];
            }
        }

    }

    public void decrease() {

        if (map[1][1] > 0) map[1][1]--;
        if (map[1][n] > 0) map[1][n]--;
        if (map[n][1] > 0) map[n][1]--;
        if (map[n][n] > 0) map[n][n]--;

        for (int i = 2; i < n; i++) {
            if (map[i][1] > 0) map[i][1]--;
            if (map[i][n] > 0) map[i][n]--;
            if (map[1][i] > 0) map[1][i]--;
            if (map[n][i] > 0) map[n][i]--;
        }
    }

    public void solve() {
        int time = 1;
        while (time < 100) {

            // 1. 에어컨 전파
            blow();

            // 2. 시원함 공기 섞임.
            mixed();

            // 3. 외벽 시원함 감소.
            decrease();

            if (finish()) break;
            time++;
        }

        if (time >= 100) {
            time = -1;
        }
        System.out.println(time);

    }

    public boolean finish() {
        for (Samosil s : samosilList) {
            if (map[s.x][s.y] < k) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.

        CT_240406 m = new CT_240406();
        m.input();
        m.solve();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    samosilList.add(new Samosil(i, j));
                } else if (v >= 2) {
                    airconList.add(new Aircon(i, j, v));
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            wall[x][y][dir] = true;
        }

    }
}

