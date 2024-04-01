package study_alone;

import java.io.*;
import java.util.*;

/** 240401 프로그래머스 경주로건설 */
public class P_240401 {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][][] vis = new boolean[26][26][4];
    int[][] price = new int[26][26];
    int n;

    class Pair {
        int x, y, dir, cost;
        Pair(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

    public int bfs(int[][] board) {
        int res = Integer.MAX_VALUE;
        Queue<Pair> qu = new LinkedList<>();

        for (int[] p : price) {
            Arrays.fill(p, Integer.MAX_VALUE);
        }

        qu.add(new Pair(0, 0, -1, 0));
        price[0][0] = 100;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int x = p.x, y = p.y, dir = p.dir;

            if (x == n-1 && y == n-1) {
                res = Math.min(res, p.cost);
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                int nCost = p.cost;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (board[nx][ny] == 1) continue;
                if (vis[nx][ny][k]) continue;

                if (dir == -1 || dir == k) {
                    // 직선방향이면,
                    nCost += 100;
                } else {
                    nCost += 600;
                }

                if (price[nx][ny] >= nCost && !vis[nx][ny][k]) {
                    vis[nx][ny][k] = true;
                    price[nx][ny] = nCost;
                    qu.add(new Pair(nx, ny, k, nCost));
                }
            }

        }
        return res;

    }

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        answer = bfs(board);
        return answer;
    }
}