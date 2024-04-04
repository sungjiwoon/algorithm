package study_alone;

import java.io.*;
import java.util.*;

/** 240404 싸움땅 골드 2 구현 */
public class CT_240404 {
    int n, m, k;
    final int MAX_N = 21;
    final int MAX_M = 401;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    Player[] playerList = new Player[MAX_M];
    int[][] playerMap = new int[MAX_N][MAX_N];
    PriorityQueue<Integer>[][] gunMap = new PriorityQueue[MAX_N][MAX_N];
    int[] pointList;

    Player winner, loser;
    int winnerIdx, loserIdx;

    class Player {
        int x, y, d, s;
        int gun = 0;
        Player(int x, int y, int d, int s) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.s = s;
        }
    }

    public void setting(int wi, Player win, int li, Player lose) {
        winner = win;
        winnerIdx = wi;
        loser = lose;
        loserIdx = li;

    }

    public int fight(Player now, Player other, int nowIdx, int otherIdx) {
        if (now.s + now.gun == other.s + other.gun) {
            if (now.s > other.s) {
                setting(nowIdx, now, otherIdx, other);
            } else {
                setting(otherIdx, other, nowIdx, now);
            }
        } else if (now.s + now.gun > other.s + other.gun) {
            setting(nowIdx, now, otherIdx, other);
        } else {
            setting(otherIdx, other, nowIdx, now);
        }
        return Math.abs(now.s + now.gun - (other.s + other.gun));
    }

    public void loserMove() {
        int nx = loser.x + dx[loser.d];
        int ny = loser.y + dy[loser.d];
        while (nx <= 0 || ny <= 0 || nx > n || ny > n || playerMap[nx][ny] > 0) {
            loser.d = (loser.d + 1) % 4;
            nx = loser.x + dx[loser.d];
            ny = loser.y + dy[loser.d];
        }

        playerMap[nx][ny] = loserIdx;
        loser.x = nx;
        loser.y = ny;

        if (gunMap[nx][ny].isEmpty()) {
            return;
        }
        loser.gun = gunMap[nx][ny].poll();
    }

    public void move() {
        //첫번째 플레이어부터 본인이 향하고 있는 방향대로 한칸 이동.
        for (int j = 1; j <= m; j++) {
            Player now = playerList[j];

            int nx = now.x + dx[now.d];
            int ny = now.y + dy[now.d];
            if (nx <= 0 || ny <= 0 || nx > n || ny > n) {
                now.d = (now.d + 2 + 4) % 4;
                nx = now.x + dx[now.d];
                ny = now.y + dy[now.d];
            }

            playerMap[now.x][now.y] = 0;
            now.x = nx;
            now.y = ny;

            if (playerMap[nx][ny] == 0) {
                if (gunMap[nx][ny].size() > 0) {
                    if (now.gun == 0) {
                        now.gun = gunMap[nx][ny].poll();
                    } else {
                        gunMap[nx][ny].add(now.gun);
                        now.gun = gunMap[nx][ny].poll();
                    }
                }
                playerMap[nx][ny] = j;
            } else {
                // 두 플레이어의 싸움.
                int otherIdx = playerMap[nx][ny];
                Player other = playerList[otherIdx];
                int point = fight(now, other, j, otherIdx);

                pointList[winnerIdx] += point;
                gunMap[nx][ny].add(loser.gun);
                loser.gun = 0; // 진 애는 총을 놓고 가야하므로,

                playerMap[nx][ny] = winnerIdx;

                loserMove();

                gunMap[nx][ny].add(winner.gun);
                winner.gun = gunMap[nx][ny].poll();

            }

        }
    }

    public void solve() {
        for (int i = 0; i < k; i++) {
            move();
        }

        for (int i = 1; i <= m; i++) {
            System.out.print(pointList[i] + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
//        Main m = new Main();
        CT_240404 m = new CT_240404();
        m.init();
        m.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pointList = new int[m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                gunMap[i][j] = new PriorityQueue<>( (o1, o2) -> o2-o1);
                int v = Integer.parseInt(st.nextToken());
                if (v == 0) continue;
                gunMap[i][j].add(v);
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            playerList[i] = new Player(x, y, d, s);
            playerMap[x][y] = i;
        }

    }
}
