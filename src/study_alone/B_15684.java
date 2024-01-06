package study_alone;

import java.util.*;
import java.io.*;

/**
 * 230105 사다리조작 (골드 3)
 * 백트래킹 (depth 3이 최대), 사다리타기 (2차원 배열)
 */
public class B_15684 {
    private int n, h;
    private final int LEFT = -1, RIGHT = 1, NO = 0;
    private int[][] map;
    private int res = 4;

    private void dfs(int depth, int st_i, int st_j) {
        if (depth > 3) {
            return;
        } else {
            if (check()) {
                res = Math.min(res, depth);
                return;
            }
        }

        // 사다리 하나 추가 -> 2개 추가 -> 3개 추가 -> 끝
        for (int i = st_i; i < n; i++) {
            for (int j = st_j; j <= h; j++) {
                if (map[i][j] == NO && map[i + 1][j] == NO) {
                    map[i][j] = RIGHT;
                    map[i + 1][j] = LEFT;
                    dfs(depth + 1, i, j + 1);
                    map[i][j] = NO;
                    map[i + 1][j] = NO;
                }
            }
            st_j = 1;
        }
    }

    private int solve() {

        dfs(0, 1, 1);
        if (res == 4) return -1;
        return res;

    }

    private boolean check() {
        for (int i = 1; i <= n; i++) {
            int st = i, w = 1;
            while (w <= h) {
                for (int j = w; j <= h; j++) {
                    if (map[st][j] != NO) {
                        st += map[st][j];
                        w = j + 1;
                        break;
                    }
                    if (j == h) {
                        w = h + 1; //이거 안 해주면 무한 루프 돌음.
                    }
                }
            }
            if (i != st) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        B_15684 m = new B_15684();
//        Main m = new Main();
        m.init();
        System.out.println(m.solve());
    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            int m = tmp[1];
            h = tmp[2];

            map = new int[n + 1][h + 1];
            for (int i = 0; i < m; i++) {
                tmp = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                int x = tmp[0]; //가로선
                int y = tmp[1]; //세로선
                map[y][x] = RIGHT;
                map[y + 1][x] = LEFT;
            }

        } catch (Exception e){
        }
    }

}
