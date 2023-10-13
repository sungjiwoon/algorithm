package samsung;

import java.io.*;
import java.util.*;

public class Samsung_21_02_am_1 {
    int n, m;
    int[][] board, cntBoard;
    int[][] idxScore;

    Pair diceP;
    final int Up = 0, Right = 1, Down = 2, Left = 3;
    int dir = Right; //오른쪽 시작.
    int u = 1, f = 2, r = 3, b = 6;

    int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    long score = 0;

    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Dice {
        int u, f, r;
        Dice (int u, int f, int r) {
            this.u = u;
            this.f = f;
            this.r = r;
        }
    }

    public void bfs() {

        int idx = 1;
        idxScore = new int[n*n+3][2]; // 0: v, 1: cnt

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (cntBoard[x][y] != 0) continue;
                int v = board[x][y];

                Queue<Pair> qu = new LinkedList<>();
                qu.add(new Pair(x, y));
                cntBoard[x][y] = idx;

                while (!qu.isEmpty()) {
                    Pair p = qu.poll();
                    for (int k = 0; k < 4; k++) {
                        int xx = p.x + dx[k];
                        int yy = p.y + dy[k];
                        if (xx<0 || yy<0 || xx>= n || yy>=n) continue;
                        if (board[xx][yy] == v && cntBoard[xx][yy] == 0) {
                            cntBoard[xx][yy] = idx;
                            qu.add(new Pair(xx, yy));
                        }
                    }
                }
                idxScore[idx][0] = v;
                idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                idxScore[cntBoard[i][j]][1]++;
            }
        }
    }

    public void move() {

        //주사위 좌표의 이동.
        int x = diceP.x, y = diceP.y;
        int nx = x + dx[dir], ny = y + dy[dir];

        //이동한 위치가 범위를 넘어가면, : 반대방향
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
            dir = (dir + 4 + 2) % 4;
            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        diceP = new Pair(nx, ny);

        //구른후 밑면의 값 변화.
        Dice dice = null;
        switch (dir) {
            case Up:
                dice = new Dice(f, 7-u, r);
                break;
            case Right:
                dice = new Dice(7-r, f, u);
                break;
            case Down:
                dice = new Dice(7-f, u, r);
                break;
            case Left:
                dice = new Dice(r, f, 7-u);
                break;
        }

        u = dice.u;
        f = dice.f;
        r = dice.r;
        b = 7 - u;

        //이동한 후 밑면 < board[nx][ny] : 반시계90 (u->l->d->r)
        //이동한 후 밑면 > board[nx][ny] : 시계90(u->r->d->l)
        //이동한 후 밑면  = board[nx][ny] : 동일한 방향
        if (b < board[nx][ny]) {
            dir = (dir-1+4) % 4;
        } else if (b > board[nx][ny]) {
            dir = (dir+1+4) % 4;
        }

    }
    public void solve() {
        diceP = new Pair(0, 0);
        dir = 1; //오른쪽 시작.
        bfs();
        for (int i = 0; i < m; i++) {
            //주사위가 놓여있는 칸의 값.
            //주사위 이동
            move();

            int idx = cntBoard[diceP.x][diceP.y];
            long tmp = idxScore[idx][0] * idxScore[idx][1];
            score += tmp;
            // System.out.println(diceP.x + "," + diceP.y + ":" + tmp);
        }
        System.out.println(score);
    }


    public static void main(String[] args) {
        Samsung_21_02_am_1 m = new Samsung_21_02_am_1();
        m.input();
        m.solve();
    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);
            board = new int[n][n];
            cntBoard = new int[n][n];
            for (int i = 0; i < n; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (Exception e) {}
    }
}

