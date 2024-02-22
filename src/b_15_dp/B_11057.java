package b_15_dp;

import java.io.*;
import java.util.*;

/** 240222 백준 오르막수 실버1 DP */

public class B_11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[1001][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= n; i++) {
            dp[i][9] = 1;
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = dp[i-1][j] + dp[i][j+1];
                dp[i][j] %= 10007;
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
            sum %= 10007;
        }
        System.out.println(sum);

    }
}
