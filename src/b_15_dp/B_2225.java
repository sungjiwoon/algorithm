package b_15_dp;

import java.io.*;
import java.util.*;

/** 240328 백준 합분해 골드 5 DP */

public class B_2225 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] dp = new long[201][201];
        Arrays.fill(dp[1], 1L);

        for (int i = 2; i <= k; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= 1000000000;
            }
        }
        System.out.println(dp[k][n]);
    }
}
