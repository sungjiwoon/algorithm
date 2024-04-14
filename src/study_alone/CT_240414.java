package study_alone;

import java.io.*;
import java.util.*;

/** 240414 삼성 술레잡기 체스 골드 2 백트레킹 + 구현 */
public class CT_240414 {
    final int N = 4;
    final int M = 17;
    int[][] map = new int[N][N];

    boolean[] notlive = new boolean[M];
    Pair[] thief = new Pair[M];
    Pair tagger;
    int res = 0;

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    class Pair {
        int x, y, dir;
        Pair (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    public boolean canGo(int x, int y) {
        return isRange(x, y) && !(tagger.x == x && tagger.y == y);
    }

    public void swap(int i, int x, int y, int dir, int nx, int ny) {
        int meIdx = map[x][y], youIdx = map[nx][ny];
        // System.out.println(String.format("meIdx : %d, i : %d", meIdx, i));
        Pair you = thief[youIdx];
        int ydir = you.dir;

        map[nx][ny] = meIdx;
        map[x][y] = youIdx;
        thief[meIdx] = new Pair(nx, ny, dir);
        thief[youIdx] = new Pair(x, y, ydir);
    }

    public void move() {
        for (int i = 1; i < M; i++) {
            if (notlive[i]) continue;

            Pair p = thief[i];
            int px = p.x, py = p.y, dir = p.dir;

            for (int d = 0; d < 8; d++) {
                int mvDir = (dir + d) % 8;
                int nx = px + dx[mvDir], ny = py + dy[mvDir];

                if (canGo(nx, ny)) {
                    if (map[nx][ny] > 0) {
                        swap(i, px, py, mvDir, nx, ny);
                    } else {
                        map[nx][ny] = map[px][py];
                        map[px][py] = 0;
                        thief[i] = new Pair(nx, ny, mvDir);
                    }
                    break;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] copy(int[][] oriMap) {
        int[][] copyMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyMap[i][j] = oriMap[i][j];
            }
        }
        return copyMap;
    }

    public boolean done(int x, int y, int dir) {
        for (int i = 1; i < N; i++) {
            int nx = x + i * dx[dir];
            int ny = y + i * dy[dir];
            if (isRange(nx, ny) && map[nx][ny] > 0) return true;
        }
        return false;
    }

    public boolean[] copyBoolean(boolean[] b) {
        boolean[] cp = new boolean[M];
        for (int i = 0; i < M; i++) {
            cp[i] = b[i];
        }
        return cp;
    }

    public Pair[] copyPair(Pair[] p) {
        Pair[] cp = new Pair[M];
        for (int i = 1; i < M; i++) {
            cp[i] = new Pair(p[i].x, p[i].y, p[i].dir);
        }
        return cp;
    }

    public void searchThief(int tx, int ty, int tdir, int score) {

        if (!done(tx, ty, tdir)) {
            res = Math.max(res, score);
            return;
        }

        int[][] tmpMap = copy(map);
        boolean[] tmpLive = copyBoolean(notlive);
        Pair[] tmpThief = copyPair(thief);

        for (int i = 1; i < N; i++) {
            int nx = tx + i * dx[tdir];
            int ny = ty + i * dy[tdir];

            if (!isRange(nx, ny) || map[nx][ny] == 0) continue;

            int ct = map[nx][ny];
            Pair p = thief[ct];

            // 해당 도둑말을 잡는 경우
            notlive[ct] = true;
            map[nx][ny] = 0;
            tagger = new Pair(nx, ny, p.dir);
            move();

            searchThief(nx, ny, p.dir, score + ct);

            thief = copyPair(tmpThief);
            map = copy(tmpMap);
            notlive = copyBoolean(tmpLive);
            tagger = new Pair(tx, ty, tdir);
        }
    }


    public void solve() {
        // (0, 0) 잡는다.
        Pair p = thief[map[0][0]];
        tagger = new Pair(p.x, p.y, p.dir);
        notlive[map[0][0]] = true;
        int score = map[0][0];
        map[0][0] = 0;
        move();

        searchThief(tagger.x, tagger.y, tagger.dir, score);
        System.out.println(res);

    }



    public static void main(String[] args) throws Exception {
        CT_240414 m = new CT_240414();
        m.init();
        m.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int p = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                map[i][j] = p;
                thief[p] = new Pair(i, j, d-1);
            }
        }

    }
}

