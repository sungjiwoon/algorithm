package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 250205 1,2,3 더하기 8 실버 1

public class B_15993 {
    public static void main(String[] args) throws Exception {
        long[][] dp = new long[100001][2]; // 0- 짝, 1- 홀

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][0] = 1;
        dp[3][0] = dp[2][1] + dp[1][1];
        dp[3][1] = dp[2][0] + dp[1][0] + 1;
        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = dp[i-1][1]+dp[i-2][1]+dp[i-3][1];
            dp[i][1] = dp[i-1][0]+dp[i-2][0]+dp[i-3][0];
            dp[i][0] %= 1000000009;
            dp[i][1] %= 1000000009;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            System.out.println(dp[v][1] + " " + dp[v][0]);
        }

    }
}
