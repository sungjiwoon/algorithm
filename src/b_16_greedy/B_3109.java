package b_16_greedy;

import java.io.*;
import java.util.*;
/** 240320 백준 3109 빵집 그리디, 재귀 */
public class B_3109 {
    static int R, C;
    static char[][] map;
    static boolean[][] vis;

    private static boolean check(int i, int j) {
        vis[i][j] = true;
        //이미 확인한 지점은 굳이 안봐도 되기 때문에 방문 표시해줌.

        // 오른쪽 위 -> 오른쪽 -> 오른쪽 아래순으로 봐야함. (R을 0부터 봤으니)

        //종료 지점
        if (j == C-1) return true;

        //오른쪽 위
        if (i-1 >= 0 && !vis[i-1][j+1] && map[i-1][j+1] == '.') {
            if (check(i-1, j+1)) return true;
            //이미 오른쪽 위에 파이프 깔았으므로 나머지 안봐도됨.
        }

        // 오른쪽
        if (j+1 < C && !vis[i][j+1] && map[i][j+1] == '.') {
            if (check(i, j+1)) return true;
        }

        //오른쪽 아래
        if (i+1 < R && !vis[i+1][j+1] && map[i+1][j+1] == '.') {
            if (check(i+1, j+1)) return true;
        }

        return false;
    }
    private static int solve() {
        vis = new boolean[R][C];
        int res = 0;
        for (int i = 0; i < R; i++) {
            if (check(i, 0)) res++;
        }

        return res;
    }
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(solve());
    }

    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(tz.nextToken());
            C = Integer.parseInt(tz.nextToken());
            map = new char[R][C];
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
            }
        } catch (Exception e) {}
    }
}
