package study_alone;

import java.io.*;
import java.util.*;
/** 240411 정육면체 한번 더 굴리기 골드 3 */
public class CT_240411 {
    final int N = 21;
    final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;
    int n, m;
    int[][] map = new int[N][N];
    int[][] score = new int[N][N];

    int res = 0;

    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    Pair loc = new Pair(1, 1);

    int U = 1, F = 2, R = 3, D = 6;
    int dir = RIGHT;

    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs(int x, int y) {

        Queue<Pair> qu = new LinkedList<>();
        Queue<Pair> visQ = new LinkedList<>();

        int cnt = 0;
        qu.add(new Pair(x, y));
        boolean[][] vis = new boolean[N][N];
        vis[x][y] = true;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            cnt++;
            visQ.add(p);
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k], ny = p.y + dy[k];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n || vis[nx][ny] || map[nx][ny] != map[x][y]) continue;
                qu.add(new Pair(nx, ny));
                vis[nx][ny] = true;
            }
        }

        int value = cnt * map[x][y];
        while(!visQ.isEmpty()) {
            Pair p = visQ.poll();
            int px = p.x, py = p.y;
            score[px][py] = value;
        }
    }

    public void scoreInit() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (score[i][j] > 0) continue;
                bfs(i, j);
            }
        }
    }

    public void move() {
        int x = loc.x, y = loc.y;
        int nx = x + dx[dir], ny = y + dy[dir];
        if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
            dir = (dir + 2) % 4;
            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        loc = new Pair(nx, ny);

        int tmpU = U, tmpR = R, tmpF = F;
        if (dir == RIGHT) {
            R = tmpU;
            U = 7 - tmpR;
        } else if (dir == LEFT) {
            U = tmpR;
            R = 7 - tmpU;
        } else if (dir == DOWN) {
            U = 7 - tmpF;
            F = tmpU;
        } else if (dir == UP) {
            U = tmpF;
            F = 7 - tmpU;
        }
        D = 7 - U;
    }


    public void solve() {
        scoreInit();
        for (int i = 0; i < m; i++) {
            // 주사위 움직임.
            move();

            res += score[loc.x][loc.y];

            // 주사위 회전
            int now = map[loc.x][loc.y];
            if (now > D) {
                dir = (dir -1 + 4) % 4;
            } else if (now < D) {
                dir = (dir +1 + 4) % 4;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        CT_240411 m = new CT_240411();
        m.init();
        m.solve();
    }

    public void init() throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
