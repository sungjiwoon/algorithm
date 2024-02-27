package hell_study;

import java.io.*;
import java.util.*;

/** 240227 백준 6593 상범 빌딩 BFS 응용 */

public class B_6593 {
    int L, R, C;
    Pair st;
    char[][][] map;
    final char NOT_MOVE = '#', CAN_MOVE = '.', END = 'E', START = 'S';

    class Pair {
        int l, r, c; // 층, 세로줄, 가로줄
        Pair (int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    private int bfs() {
        // 동 서 남 북 상 하
        int[] dr = {0, 0, 1, -1, 0, 0}, dc = {-1, 1, 0, 0, 0, 0}, dl = {0, 0, 0, 0, 1, -1};
        int[][][] vis = new int[L][R][C];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                Arrays.fill(vis[i][j], Integer.MAX_VALUE);
            }
        }
        Deque<Pair> qu = new LinkedList<>();
        qu.add(st);
        vis[st.l][st.r][st.c] = 0;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int l = p.l, r = p.r, c = p.c;
            if (map[l][r][c] == END) {
                return vis[l][r][c];
            }
            for (int k = 0; k < 6; k++) {
                int nl = l + dl[k];
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (isRange(nl, nr, nc) && map[nl][nr][nc] != NOT_MOVE && vis[nl][nr][nc] > vis[l][r][c] + 1) {
                    qu.add(new Pair(nl, nr, nc));
                    vis[nl][nr][nc] = vis[l][r][c] + 1;
                }
            }
        }

        return -1;

    }

    private boolean isRange(int l, int r, int c) {
        return (l >= 0 && l < L && r >= 0 && r < R && c >= 0 && c < C);
    }

    private StringBuilder solve() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            input(br);
            if (L == 0 && R == 0 && C == 0) return sb;

            int ans = bfs();
            if (ans == -1) sb.append("Trapped!\n");
            else sb.append(String.format("Escaped in %d minute(s).\n", ans));

        }

    }
    public static void main(String[] args) {
        B_6593 b = new B_6593();
        System.out.println(b.solve());
    }

    private void input(BufferedReader br) {
        try {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            L = tmp[0];
            R = tmp[1];
            C = tmp[2];
            map = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    map[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == START) {
                            st = new Pair(i, j, k);
                        }
                    }
                }
                br.readLine();
            }
        } catch (Exception e) {}
    }
}
