package study_alone;

import java.io.*;
import java.util.*;
/** 240411 정육면체 한번 더 굴리기 골드 3*/
public class CT_240411 {
    final int N = 21;
    final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;
    int n, m;
    int[][] map = new int[N][N];
    int[][] score = new int[N][N];

    int res = 0;

    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    int dir = RIGHT, dice = 0; // 초기 방향 : 오른쪽, 다이스 아래 : rightDice[0];
    int bottom = 6;
    Pair loc = new Pair(1, 1);
    int[] rightDice = {6, 3, 1, 4};
    int[] downDice = {6, 2, 1, 5};


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

        if (dir == RIGHT) {
            dice = (dice+1) % 4;
            bottom = rightDice[dice];
        } else if (dir == LEFT) {
            dice = (dice +4 -1) % 4;
            bottom = rightDice[dice];
        } else if (dir == DOWN) {
            dice = (dice+1) % 4;
            bottom = downDice[dice];
        } else if (dir == UP) {
            dice = (dice +4 -1) % 4;
            bottom = upDice[dice];
        }

    }


    public void solve() {
        scoreInit();
        for (int i = 0; i < m; i++) {
            // 주사위 움직임.
            move();

            res += score[loc.x][loc.y];

            // 주사위 회전
            int now = map[loc.x][loc.y];
            if (now > bottom) {
                dir = (dir -1 + 4) % 4;
            } else if (now < bottom) {
                dir = (dir +1 + 4) % 4;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
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
