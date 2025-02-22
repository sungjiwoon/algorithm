package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 250222 출근 경로 골드4

public class B_5569 {
    int w, h;
    final int MOD = 100000;

    private void solve() {
        int[][][][] dp = new int[w+1][h+1][2][2];
        // i, j, 방향, 방향 전환 여부
        // 0: 오른쪽, 1: 아래쪽
        // 0: 꺾기 불가능,  1 : 꺾기 가능함
        for (int i = 2; i <= w; i++) {
            dp[i][1][0][0] = 1;
        }

        for (int i = 2; i <= h; i++) {
            dp[1][i][1][0] = 1;
        }

        /**
         * dp[x][y][오른쪽][꺾기X] = dp[x-1][y][오른쪽][꺾기O]+dp[x-1][y][오른쪽][꺾기X]
         * dp[x][y][오른쪽][꺾기O] = dp[x-1][y][오른쪽][꺾기X]
         */
        for (int i = 2; i <= w; i++) {
            for (int j = 2; j <= h; j++) {
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % MOD;
                dp[i][j][0][1] = dp[i-1][j][1][0] % MOD;
                dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % MOD;
                dp[i][j][1][1] = dp[i][j-1][0][0] % MOD;

            }
        }

        int res = dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1];
        res %= MOD;

        System.out.println(res);
    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_5569 b = new B_5569();
        b.init();
    }
}
