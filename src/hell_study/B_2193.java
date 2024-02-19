package hell_study;

import java.io.*;
/** 240220 백준 이친수 실버 3 DP */

public class B_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[91][2];
        dp[1][0] = 0; // 끝자리가 0인 경우
        dp[1][1] = 1; // 끝자리가 1인 경우
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0]; // 11은 불가능
        }
        long ans = dp[n][0] + dp[n][1];
        System.out.println(ans);

    }
}
