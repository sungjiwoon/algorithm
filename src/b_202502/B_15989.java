package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 250205 1,2,3 더하기 5 골드5

public class B_15989 {
    static final int INF = 10001;
    public static void main(String[] args) throws Exception {
        int[][] dp = new int[INF][4];
        // dp[i][1] -> 1로 끝나는 수식의 합
        // dp[i][2] -> 2로 끝나는 수식의 합
        // dp[i][3] -> 3으로 끝나는 수식의 합

        dp[1][1] = 1;
        dp[2][1] = dp[2][2] = 1;
        dp[3][1] = dp[3][2] = dp[3][3] = 1;
        for (int i = 4; i < INF; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            int sum = dp[v][1] + dp[v][2] + dp[v][3];
            System.out.println(sum);
        }

    }
}
