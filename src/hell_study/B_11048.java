package hell_study;
import java.util.*;
import java.io.*;

/** 240215 이동하기 실버 2 DP */

public class B_11048 {
    int n, m;
    int[][] map;
    private int solve() {
        int[] dx = {-1, 0, -1}, dy = {0, -1, -1};
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int bx = i + dx[k], by = j + dy[k];
                    if (bx < 0 || by < 0 || bx >= n || by >= m) continue;
                    dp[i][j] = Math.max(dp[bx][by], dp[i][j]);
                }
                dp[i][j] += map[i][j];
            }
        }

        return dp[n-1][m-1];
    }
    public static void main(String[] args) {
        B_11048 b = new B_11048();
//        Main b = new Main();
        b.input();
        System.out.println(b.solve());
    }
    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            m = tmp[1];
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch(Exception e) {}
    }
}
