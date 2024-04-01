package study_alone;


import java.io.*;
import java.util.*;

/** 240401 프로그래머스 경주로건설 */
public class P_240401 {
    final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    final int CONNER = 500, ST = 100;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][][] vis = new boolean[26][26][4];
    int n;

    class Pair {
        int x, y, dir, p;
        Pair(int x, int y, int dir, int p) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.p = p;
        }
    }

    public int bfs(int[][] board) {
        Queue<Pair> qu = new LinkedList<>();
        int[][] price = new int[26][26];

        for (int[] p : price) {
            Arrays.fill(p, Integer.MAX_VALUE);
        }

        for (int k = 0; k < 4; k++) {
            qu.add(new Pair(0, 0, k, 100));
            vis[0][0][k] = true;
            price[0][0] = 100;
        }


        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int x = p.x;
            int y = p.y;
            int dir = p.dir;
            int pp = p.p;

            System.out.println(String.format("{%d, %d} dir : %d, price : %d", x, y, dir, pp));

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (board[nx][ny] == 1) continue;
                if (vis[nx][ny][k]) continue;

                if (dir == UP || dir == DOWN) {
                    if (k == UP || k == DOWN) {
                        if (price[nx][ny] >= pp + ST) {
                            System.out.println(String.format("UD nx {%d, %d} dir : %d, price : %d", nx, ny, k, pp + ST));
                            price[nx][ny] = pp + ST;
                            qu.add(new Pair(nx, ny, k, pp + ST));
                            vis[nx][ny][k] = true;
                        }
                    } else {
                        if (price[nx][ny] >= pp + CONNER) {
                            System.out.println(String.format("LR nx {%d, %d} dir : %d, price : %d", nx, ny, k, pp + CONNER));
                            price[nx][ny] = pp + CONNER;
                            qu.add(new Pair(nx, ny, k, pp + CONNER));
                            vis[nx][ny][k] = true;
                        }
                    }
                } else {
                    if (k == UP || k == DOWN) {
                        if (price[nx][ny] >= pp + CONNER) {
                            System.out.println(String.format("UD nx {%d, %d} dir : %d, price : %d", nx, ny, k, pp + CONNER));
                            price[nx][ny] = pp + CONNER;
                            qu.add(new Pair(nx, ny, k, pp + CONNER));
                            vis[nx][ny][k] = true;
                        }
                    } else {
                        if (price[nx][ny] >= pp + ST) {
                            System.out.println(String.format("LR nx {%d, %d} dir : %d, price : %d", nx, ny, k, pp + ST));
                            price[nx][ny] = pp + ST;
                            qu.add(new Pair(nx, ny, k, pp + ST));
                            vis[nx][ny][k] = true;
                        }
                    }
                }
            }

        }
        return price[n-1][n-1];

    }

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        answer = bfs(board);
        return answer;
    }
}