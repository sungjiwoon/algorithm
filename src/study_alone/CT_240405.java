package study_alone;
import java.io.*;
import java.util.*;
/** 240405 코드트리 포탑 부수기 골드 1 BFS, 구현 */
public class CT_240405 {

    final int MAX_N = 11, MAX_M = 11;
    int n, m, k;
    int turn = 0;
    int diedTop = 0;

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int[][] map = new int[MAX_N][MAX_M];
    boolean[][] attackedMap = new boolean[MAX_N][MAX_M];
    int[][] turnMap = new int[MAX_N][MAX_M];
    List<Top> topList = new ArrayList<>();
    Top attacker, attacted;

    class Top implements Comparable<Top> {
        int x, y;
        Top (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Top other) {
            if (map[this.x][this.y] != map[other.x][other.y]) return map[this.x][this.y] - map[other.x][other.y];
            if (turnMap[this.x][this.y] != turnMap[other.x][other.y]) return turnMap[other.x][other.y] - turnMap[this.x][this.y];
            if ((this.x + this.y) != (other.x + other.y)) return (other.x + other.y) - (this.x + this.y);
            return other.y - this.y;
        }
    }

    public void selectAttacker() {
        Collections.sort(topList);
        attacker = topList.get(0);
        int x = attacker.x;
        int y = attacker.y;

        map[x][y] += (n + m);
        attackedMap[x][y] = true;
        turnMap[x][y] = turn;
    }

    public void selectAccacted() {
        attacted = topList.get(topList.size()-1);
    }

    public boolean laser() {
        Queue<int[]> qu = new LinkedList<>();
        int stX = attacker.x, stY = attacker.y;
        int enX = attacted.x, enY = attacted.y;

        qu.add(new int[]{stX, stY});
        int[][] beforeX = new int[MAX_N][MAX_M];
        int[][] beforeY = new int[MAX_N][MAX_M];
        boolean[][] vis = new boolean[MAX_N][MAX_M];
        vis[stX][stY] = true;

        boolean ok = false;

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            if (q[0] == enX && q[1] == enY) {
                ok = true;
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nx = q[0] + dx[d];
                int ny = q[1] + dy[d];
                if (nx > n) nx = 1;
                if (nx == 0) nx = n;
                if (ny > m) ny = 1;
                if (ny == 0) ny = m;

                if (vis[nx][ny]) continue;
                if (map[nx][ny] <= 0) continue;

                vis[nx][ny] = true;
                beforeX[nx][ny] = q[0];
                beforeY[nx][ny] = q[1];
                qu.add(new int[]{nx, ny});
            }
        }

        if (!ok) return false;

        int power = map[stX][stY];
        attackedPower(enX, enY, power);

        int bx = beforeX[enX][enY], by = beforeY[enX][enY];
        while (!(bx == stX && by == stY)) {
            attackedPower(bx, by, power/2);

            int tmpX = bx, tmpY = by;
            bx = beforeX[tmpX][tmpY];
            by = beforeY[tmpX][tmpY];
        }
        return true;

    }

    public void attackedPower(int x, int y, int power) {
        map[x][y] -= power;
        attackedMap[x][y] = true;
        if (map[x][y] <= 0) {
            map[x][y] = 0;
            diedTop--;
        }
    }

    public void attackBomb() {
        int[] ddx = {-1,-1,-1,0,0,1,1,1};
        int[] ddy = {-1,0,1,-1,1,-1,0,1};
        int stX = attacker.x, stY = attacker.y;
        int enX = attacted.x, enY = attacted.y;

        int power = map[stX][stY];
        attackedPower(enX, enY, power);

        for (int d = 0; d < 8; d++) {
            int nx = enX + ddx[d];
            int ny = enY + ddy[d];
            if (nx > n) nx = 1;
            if (nx == 0) nx = n;
            if (ny > m) ny = 1;
            if (ny == 0) ny = m;
            if (map[nx][ny] <= 0) continue;
            if (nx == stX && ny == stY) continue;

            attackedPower(nx, ny, power/2);
        }
    }

    public void clearMap() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] <= 0 || attackedMap[i][j]) continue;
                map[i][j]++;
            }
        }
    }

    public void newTopList() {
        attackedMap = new boolean[MAX_N][MAX_M];
        topList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] > 0) {
                    topList.add(new Top(i, j));
                }
            }
        }
        diedTop = topList.size();
    }

    public void solve() {
        for (int t = 1; t <= k; t++) {
            turn = t;

            newTopList();
            if (diedTop == 1) break;

            // 1. 공격자 선정
            selectAttacker();

            // 2. 공격받은자 선정
            selectAccacted();

            // 3. 레이저 공격
            if (!laser()) {
                // 4. 포탄 공격
                attackBomb();
            }

            if (diedTop == 1) break;

            // 5. 포탄 정비
            clearMap();
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(max, map[i][j]);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        CT_240405 m = new CT_240405();
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
            for (int j = 1; j <= m; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
            }
        }

    }


}