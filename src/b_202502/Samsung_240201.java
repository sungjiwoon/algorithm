package b_202502;


import java.util.*;
import java.io.*;

public class Samsung_240201 {

    int N, M;
    int[][] borad;

    final int INF = 300;

    Pair[] army; // 전사 최초 위치들
    boolean[] deadarmy, icearamy;
    List<Integer>[][] armyMap;
    boolean[][] canlook;

    int sr, sc, er, ec; // 메두사, 공원 위치
    int[][] dis;

    int asum = 0, astone = 0, attackCnt = 0;

    boolean[][] dontLook;
    int cntMax = 0;
    int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

    class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    int getD(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    boolean bfs() {

        Queue<Pair> qu = new LinkedList<>();
        dis = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dis[i], INF);
        }
        dis[er][ec] = 0;
        qu.add(new Pair(er, ec));

        while (!qu.isEmpty()) {
            Pair q = qu.poll();
            int r = q.r, c = q.c;

            if (r == sr && c == sc) {
                return true;
            }
            for (int k = 0; k < 4; k++) { // 헷갈림
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (borad[nr][nc] == 1) continue;
                if (dis[nr][nc] == INF) {
                    dis[nr][nc] = dis[r][c] + 1;
                    qu.add(new Pair(nr, nc));
                }
            }
        }
        return false;
    }

    void up() {
        // 상
        dontLook = new boolean[N][N];
        boolean[] tmpIce = new boolean[M];
        boolean[][] tmpLook = new boolean[N][N];

        int o = 1;
        int cnt = 0;
        for (int r = sr - 1; r >= 0; r--) {
            for (int c = sc - o; c <= sc + o; c++) {
                if (c < 0 || c >= N) continue;
                if (dontLook[r][c]) continue;
                tmpLook[r][c] = true;
                if (armyMap[r][c].size() >= 1) {
                    cnt += armyMap[r][c].size();
                    for (int idx : armyMap[r][c]) {
                        tmpIce[idx] = true;
                    }

                    // 방향 3가지 (-1, -1) (-1, 0) (-1, 1)
                    int dir = 0;
                    if (c == sc) dir = 0;
                    else if (c > sc) dir = 1;
                    else if (c < sc) dir = -1;
                    int oo = 1;

                    for (int rr = r - 1; rr >= 0; rr--) {
                        int cc = c;
                        dontLook[rr][cc] = true;
                        if (dir != 0) {
                            for (int dd = 1; dd <= oo; dd++) {
                                cc = c + dd * dir; //6, 67
                                if (cc < 0 || cc >= N) continue;
                                dontLook[rr][cc] = true;
                            }
                            oo++;
                        }
                    }
                }
            }
            o++;
        }

        System.out.println("= UP =");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sr == i && j == sc) {
                    System.out.print("S ");
                }else if (tmpLook[i][j] && !dontLook[i][j]) {
                    System.out.print("V ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
        System.out.println();


        cntMax= cnt;
        icearamy = tmpIce;
        canlook = tmpLook;
        System.out.println("UP");
    }

    void down() {
        dontLook = new boolean[N][N];
        boolean[] tmpIce = new boolean[M];
        boolean[][] tmpLook = new boolean[N][N];

        int o = 1;
        int cnt = 0;
        for (int r = sr + 1; r < N; r++) {
            for (int c = sc - o; c <= sc + o; c++) {
                if (c < 0 || c >= N) continue;
                if (dontLook[r][c]) continue;
                tmpLook[r][c] = true;
                if (armyMap[r][c].size() >= 1) {
                    cnt += armyMap[r][c].size();
                    for (int idx : armyMap[r][c]) {
                        tmpIce[idx] = true;
                    }

                    // 방향 3가지 (1, -1) (1, 0) (1, 1)
                    int dir = 0;
                    if (c == sc) dir = 0;
                    else if (c > sc) dir = 1;
                    else if (c < sc) dir = -1;
                    int oo = 1;

                    for (int rr = r + 1; rr < N; rr++) {
                        int cc = c;
                        dontLook[rr][cc] = true;
                        if (dir != 0) {
                            for (int dd = 1; dd <= oo; dd++) {
                                cc = c + dd * dir; // cc -1, 0 or 0, 1
                                if (cc < 0 || cc >= N) continue;
                                dontLook[rr][cc] = true;
                            }
                            oo++;
                        }
                    }
                }
            }
            o++;
        }

        System.out.println("= DOWN =");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sr == i && j == sc) {
                    System.out.print("S ");
                }else if (tmpLook[i][j] && !dontLook[i][j]) {
                    System.out.print("V ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
        System.out.println();

        if (cnt > cntMax) {
            cntMax = cnt;
            icearamy = tmpIce;
            canlook = tmpLook;
            System.out.println("DOWN");
        }
    }

    void left() {
        dontLook = new boolean[N][N];
        boolean[] tmpIce = new boolean[M];
        boolean[][] tmpLook = new boolean[N][N];

        int o = 1;
        int cnt = 0;
        for (int c = sc - 1; c >= 0; c--) {
            for (int r = sr - o; r <= sr + o; r++) {
                if (r < 0 || r >= N) continue;
                if (dontLook[r][c]) continue;
                tmpLook[r][c] = true;
                if (armyMap[r][c].size() >= 1) {
                    cnt += armyMap[r][c].size();
                    for (int idx : armyMap[r][c]) {
                        tmpIce[idx] = true;
                    }

                    // 방향 3가지 (-1, -1) (-1, 0) (-1, 1)
                    int dir = 0;
                    if (r == sr) dir = 0;
                    else if (r > sr) dir = 1;
                    else if (r < sr) dir = -1;

                    int oo = 1;
                    for (int cc = c - 1; cc >= 0; cc--) {
                        int rr = r;
                        dontLook[rr][cc] = true;
                        if (dir != 0) {
                            for (int dd = 1; dd <= oo; dd++) {
                                rr = r + dd * dir;
                                if (rr < 0 || rr >= N) continue;
                                dontLook[rr][cc] = true;
                            }
                            oo++;
                        }
                    }
                }
            }
            o++;
        }
        System.out.println("= LEFT =");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sr == i && j == sc) {
                    System.out.print("S ");
                }else if (tmpLook[i][j] && !dontLook[i][j]) {
                    System.out.print("V ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
        System.out.println();

        if (cnt > cntMax) {
            cntMax = cnt;
            icearamy = tmpIce;
            canlook = tmpLook;
            System.out.println("LEFT");
        }
    }

    void right() {
        dontLook = new boolean[N][N];
        boolean[] tmpIce = new boolean[M];
        boolean[][] tmpLook = new boolean[N][N];

        int o = 1;
        int cnt = 0;
        for (int c = sc + 1; c < N; c++) {
            for (int r = sr - o; r <= sr + o; r++) {
                if (r < 0 || r >= N) continue;
                if (dontLook[r][c]) continue;
                tmpLook[r][c] = true;
                if (armyMap[r][c].size() >= 1) {
                    cnt += armyMap[r][c].size();
                    for (int idx : armyMap[r][c]) {
                        tmpIce[idx] = true;
                    }

                    // 방향 3가지 (-1, -1) (-1, 0) (-1, 1)
                    int dir = 0;
                    if (r == sr) dir = 0;
                    else if (r > sr) dir = 1;
                    else if (r < sr) dir = -1;
                    int oo = 1;

                    for (int cc = c + 1; cc < N; cc++) {
                        int rr = r;
                        dontLook[rr][cc] = true;
                        if (dir != 0) {
                            for (int dd = 1; dd <= oo; dd++) {
                                rr = r + dd * dir;
                                if (rr < 0 || rr >= N) continue;
                                dontLook[rr][cc] = true;
                            }
                            oo++;
                        }
                    }
                }
            }
            o++;
        }
        System.out.println("= RIGHT =");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (sr == i && j == sc) {
                    System.out.print("S ");
                }else if (tmpLook[i][j] && !dontLook[i][j]) {
                    System.out.print("V ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
        System.out.println();

        if (cnt > cntMax) {
            cntMax = cnt;
            icearamy = tmpIce;
            canlook = tmpLook;
            System.out.println("RIGHT");
        }
    }

    void look() {

        icearamy = new boolean[M]; // 얼어버린 군인
        canlook = new boolean[N][N]; // 볼수 있는 시야각

        // 상
        up();
        // 하
        down();
        // 좌
        left();
        // 우
        right();

    }

    void move() {
        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};

        for (int i = 0; i < M; i++) {
            if (icearamy[i] || deadarmy[i]) {
                if (icearamy[i]) {
                    astone++;
                    System.out.println("Ice " + army[i].r + " " + army[i].c);
                }
                continue;
            }

            int r = army[i].r, c = army[i].c;
            dr = new int[] {-1, 1, 0, 0};
            dc = new int[] {0, 0, -1, 1};

            int minD = getD(sr, sc, r, c);
            int minDir = -1;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (canlook[nr][nc]) continue;
                int d = getD(sr, sc, nr, nc);
                if (minD > d) {
                    minDir = k;
                    minD = d;
                }
            }
            if (minDir != -1) {
                r = r + dr[minDir];
                c = c + dc[minDir];
                army[i] = new Pair(r, c);
                asum++;
            } else {
                continue;
            }

            // 2번째 이동
            minD = getD(sr, sc, r, c);
            minDir = -1;
            dr = new int[] {0,0,-1, 1};
            dc = new int[] {-1, 1, 0, 0};
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (canlook[nr][nc]) continue;
                int d = getD(sr, sc, nr, nc);
                if (minD > d) {
                    minDir = k;
                    minD = d;
                }
            }
            if (minDir != -1) {
                r = r + dr[minDir];
                c = c + dc[minDir];
                asum++;
                army[i] = new Pair(r, c);
            }

        }
    }

    void attack() {
        for (int i = 0; i < M; i++) {
            if (icearamy[i] || deadarmy[i]) continue;

            int r = army[i].r, c = army[i].c;
            if (r == sr && c == sc) {
                deadarmy[i] = true;
                System.out.println("Attack r= " + r + ", c="+ c);
                attackCnt++;
            }
        }
    }

    void solve() {

        boolean can = bfs();
        if (!can) {
            System.out.println("-1");
            return;
        }

        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};

        int v = 0;
        while (v++ < 1) {
            asum = 0;
            astone = 0;
            attackCnt = 0;

            // 1. 메두사의 이동
            for (int k = 0; k < 4; k++) {
                int nr = sr + dr[k], nc = sc + dc[k];
                if (nr<0 || nc < 0 || nr >= N || nc >= N) continue;
                if (borad[nr][nc] == 1) continue;
                if (dis[sr][sc] > dis[nr][nc]) {
                    sr = nr;
                    sc = nc;
                    break;
                }
            }

            for (int i = 0; i < M; i++) {
                if (deadarmy[i]) continue;
                if (army[i].r == sr && army[i].c == sc) {
                    deadarmy[i] = true;
                }
            }

            armyMap = new List[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    armyMap[i][j] = new ArrayList<>();
                }
            }
            for (int i = 0; i < M; i++) {
                if (deadarmy[i]) continue;
                int r = army[i].r, c = army[i].c;
                armyMap[r][c].add(i);
            }

            System.out.println("== Army Map ==");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == sr && j == sc) {
                        System.out.print("S");
                    }
                    System.out.print(armyMap[i][j].size()+ "  ");
                }
                System.out.println();
            }
            System.out.println();

            System.out.println("sr= " + sr +", sc= "+ sc);

            if (sr == er && sc == ec) {
                System.out.println("0");
                break;
            }

            // 2. 메두사의 시선
            look();

            // 3. 전사들의 이동
            move();

            // 4. 전사들의 공격
            attack();

            // 5.
            System.out.println(asum + " " + astone + " " + attackCnt);
        }



    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            M = Integer.parseInt(str[1]);

            str = br.readLine().split(" ");
            sr = Integer.parseInt(str[0]);
            sc = Integer.parseInt(str[1]);
            er = Integer.parseInt(str[2]);
            ec = Integer.parseInt(str[3]);

            army = new Pair[M];
            deadarmy = new boolean[M];
            armyMap = new List[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    armyMap[i][j] = new ArrayList<Integer>();
                }
            }

            str = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                int r = 0;
                int c = 0;
                for (int j = 0; j < 2; j++) {
                    r = Integer.parseInt(str[i*2]);
                    c = Integer.parseInt(str[i*2+1]);
                }
                army[i] = new Pair(r, c);
                armyMap[r][c].add(i);
            }

            borad = new int[N][N];
            for (int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    borad[i][j] = Integer.parseInt(str[j]);
                }
            }

            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        Samsung_240201 b = new Samsung_240201();
        b.init();
        // Please write your code here.
    }
}