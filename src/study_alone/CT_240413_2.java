package study_alone;

import java.io.*;
import java.util.*;

/** 240413 승자독식 모노폴리 골드 2 */

public class CT_240413_2 {
    final int N = 21;
    final int M = 410;
    final int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;
    int n, m, k;
    int turn = 0;
    int[][] map = new int[N][N];
    int[][] turnMap = new int[N][N];
    int[][] monoployMap = new int[N][N]; //이동할 수 없는 칸.
    Queue<Integer>[][] moveMap = new LinkedList[N][N];
    int[][][] playerDir = new int[M][5][4]; // 이동 우선순위를 담은 것.
    Pair[] player = new Pair[M];
    boolean[] live = new boolean[M];

    int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};

    class Pair {
        int x, y, dir;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
        Pair (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public void unlock() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (turnMap[i][j] > 0) {
                    turnMap[i][j]--;
                    if (turnMap[i][j] == 0) {
                        monoployMap[i][j] = 0;
                    }
                }
            }
        }
    }

    public boolean isRange(int x, int y) {
        return (0 < x && x <= n && 0 < y && y <= n);
    }

    public String getDir(int dir) {
        if (dir == UP) return "UP";
        if (dir == DOWN) return "DOWN";
        if (dir == LEFT) return "LEFT";
        return "RIGHT";
    }

    public void move() {
        moveMap = new LinkedList[N][N];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                moveMap[i][j] = new LinkedList<>();
            }
        }

        for (int i = 1; i <= m; i++) {
            if (!live[i]) continue;
            Pair p = player[i];

            int px = p.x, py = p.y, dir = p.dir;
            int[] priDir = playerDir[i][dir];

            int cx = -1, cy = -1, cdir = -1; // 이동할 수 있는 땅.
            int mx = -1, my = -1, mdir = -1; // 독점한 부분.
            for (int pd : priDir) {
                int nx = px + dx[pd], ny = py + dy[pd];
                if (!isRange(nx, ny)) continue;
                if (cx == -1 && monoployMap[nx][ny] == 0) {
                    cx = nx;
                    cy = ny;
                    cdir = pd;
                }
                if (mx == -1 && monoployMap[nx][ny] == i) {
                    mx = nx;
                    my = ny;
                    mdir = pd;
                }
            }

            if (cx != -1) {
                moveMap[cx][cy].add(i);
                player[i] = new Pair(cx, cy, cdir);
            } else if (mx != -1) {
                moveMap[mx][my].add(i);
                player[i] = new Pair(mx, my, mdir);
            }

        }
    }

    public void clean() {
        live = new boolean[M];
        map = new int[N][N];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (moveMap[i][j].isEmpty()) continue;
                int p = moveMap[i][j].poll();
                live[p] = true;
                map[i][j] = p;
                monoployMap[i][j] = p;
                turnMap[i][j] = k;
            }
        }


    }

    public void print() {
        System.out.println("= " + turn + "째 맵 프린트 =");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean finish() {
        for (int i = 2; i <= m; i++) {
            if (live[i]) return false;
        }
        return true;
    }

    public void solve() {
        for (turn = 1; turn <= 1000; turn++) {
            // 한칸 이동.
            move();

            unlock();

            // 죽은 애들 처리.
            clean();
            if (!live[1]) {
                turn = -1;
                break;
            }
            if (finish()) break;
        }

        if (turn >= 1000) {
            turn = -1;
        }
        System.out.println(turn);
    }

    public static void main(String[] args) throws Exception {
        CT_240413 m = new CT_240413();
        m.init();
        m.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int p = Integer.parseInt(st.nextToken());
                map[i][j] = p;
                if (p > 0) {
                    player[p] = new Pair(i, j);
                    turnMap[i][j] = k;
                    monoployMap[i][j] = p;
                    live[p] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " "); // 플레이어 초기 방향
        for (int i = 1; i <= m; i++) {
            int p = Integer.parseInt(st.nextToken());
            player[i].dir = p;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int dd = 0; dd < 4; dd++) {
                    playerDir[i][j][dd] = Integer.parseInt(st.nextToken());
                }
            }
        }

    }
}

