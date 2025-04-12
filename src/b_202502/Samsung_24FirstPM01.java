package b_202502;

import java.io.*;
import java.util.*;

public class Samsung_24FirstPM01 {
    int R, C, K;
    int[][] golams;
    int[][] map;
    int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1}; // 북 동 남 서

    boolean canMoveDown(int dir, int r, int c) {
        boolean flag = (r+2 <= R+3);
        if (dir == 0) {
            flag = flag && (c-1 >= 1) && (c+1 <= C);
            flag = flag && (map[r+1][c-1] == -1) && (map[r+2][c] == -1) && (map[r+1][c+1]==-1);
        } else if (dir == 1) { // 서쪽
            flag = flag && (c-2 >= 1);
            flag = flag && (map[r][c-2]==-1) && (map[r-1][c-1]==-1) && (map[r+1][c-1]==-1);
            flag = flag && (map[r+1][c-2]==-1) && (map[r+2][c-1] == -1);
        } else {
            flag = flag && (c+2 <= C);
            flag = flag && (map[r][c+2]==-1) && (map[r-1][c+1]==-1) && (map[r+1][c+1]==-1);
            flag = flag && (map[r+1][c+2]==-1) && (map[r+2][c+1] == -1);
        }
        return flag;
    }


    boolean down(int ci, int d, int idx) {
        int r = 2, c = ci;

        while (true) {
            if (r == R+3) break;
            int dir = 0;
            boolean can = false;
            for (dir = 0; dir < 3; dir++) {
                if (canMoveDown(dir, r, c)) {
                    can = true;
                    break;
                }
            }
            if (!can) break;
            r++;
            if (dir == 1) { // 서, 방향 반시계
                c--;
                d = (d + 3) % 4;
            } else if (dir == 2) { // 동, 방향 시계
                c++;
                d = (d + 1) % 4;
            }
        }

        if (r < 5) {
            return false;
        }
        map[r-1][c] = map[r+1][c] = map[r][c-1] = map[r][c+1] = map[r][c] = idx;
        golams[idx][0] = r;
        golams[idx][1] = c;
        golams[idx][2] = d;
        return true;
    }

    int move(int idx) {
        int r = golams[idx][0], c = golams[idx][1];
        int res = r;

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{r, c});
        boolean[][] vis = new boolean[R+4][C+1];

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            r = q[0];
            c = q[1];
            idx = map[r][c];
            res = Math.max(res, r);
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr > R+3 || nc <= 0 || nc > C || vis[nr][nc] || map[nr][nc] == -1) continue;
                int idy = map[nr][nc];
                if (idx == idy) {
                    qu.add(new int[]{nr, nc});
                    vis[nr][nc] = true;
                } else {
                    // r, c가 현재 출구 위치이면 이동 가능함
                    int idxR = golams[idx][0], idxC = golams[idx][1], dd = golams[idx][2];
                    int exitR = idxR + dr[dd], exitC = idxC + dc[dd];
                    if (r == exitR && c == exitC) {
                        qu.add(new int[]{nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
        }
        return res - 3;

    }

    void solve() {
        init();
        int res = 0;

        for (int k = 0; k < K; k++) {
            // 골렘 내려감
            int[] g = golams[k];
            boolean ok = down(g[1], g[2], k);
            if (!ok) {
                map = new int[R+4][C+1];
                for (int i = 0; i < R+4; i++) {
                    Arrays.fill(map[i], -1);
                }
                continue;
            }
            int value = move(k);
            res += value;
        }
        System.out.println(res);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            R = Integer.parseInt(sp[0]);
            C = Integer.parseInt(sp[1]);
            K = Integer.parseInt(sp[2]);
            map = new int[R+4][C+1];
            for (int i = 0; i < R+4; i++) {
                Arrays.fill(map[i], -1);
            }
            golams = new int[K][3];
            for (int k = 0; k < K; k++) {
                sp = br.readLine().split(" ");
                golams[k][1] = Integer.parseInt(sp[0]);
                golams[k][2] = Integer.parseInt(sp[1]);
            }
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        // Please write your code here.
        Samsung_24FirstPM01 b = new Samsung_24FirstPM01();
        b.solve();

    }
}



