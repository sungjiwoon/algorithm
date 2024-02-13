package hell_study;

import java.io.*;
import java.util.*;

/**
 * 24-02-13 화 피보나치 함수 DP
 */

public class B_1003 {

    public static void main(String[] args) throws IOException {
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0] + " " + dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}
