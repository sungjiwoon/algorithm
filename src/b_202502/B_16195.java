package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 250205 1,2,3 더하기 9 실버 1

public class B_16195 {
    public static void main(String[] args) throws Exception {
        long[][] dp = new long[1001][1001];

        dp[1][1] = dp[2][1] = dp[3][1] = 1; // 1, 2, 3
        dp[2][2] = dp[1][1]; // 1+1
        dp[3][2] = dp[2][1] + dp[1][1]; // 2+1, 1+2
        dp[3][3] = dp[2][2]; // 1+1+1
        for (int i = 4; i <= 1000; i++) {
            for (int j = 2; j <= 1000; j++) {
                // j-1은 각 자릿수에서 한 자리 뺀 값
                dp[i][j] = dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1];
                dp[i][j] %= 1000000009;
            }
        }

        // 누적합
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                // j-1은 각 자릿수에서 한 자리 뺀 값
                dp[i][j] += dp[i][j-1];
                dp[i][j] %= 1000000009;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(dp[v][m]);
        }

    }
}
