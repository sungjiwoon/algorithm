package b_15_dp;

import java.io.*;
import java.util.*;

/** 240222 백준 오르막수 실버1 DP */

public class B_11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[1001][10]; // dp[i][j] -> 수의 길의 i의 첫째 자리수가 j인 경우의 갯수
        Arrays.fill(dp[1], 1); // n = 1은 무조건 전부 1개이다.

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
