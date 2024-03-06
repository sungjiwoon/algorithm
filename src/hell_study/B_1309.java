package hell_study;

import java.util.*;
/** 240306 백준 1309 동물원 DP */
public class B_1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n+1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i <= n; i++) {
            // dp[i][0] = 돌을 놓지 않는 경우 -> 전단계 어떤 것이든 영향을 받지 않음.
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2];
            dp[i][0] %= 9901;

            // dp[i][1] = 왼쪽에 두는 경우 -> 전단계 없는 경우 혹은 오른쪽
            dp[i][1] = dp[i-1][0] + dp[i-1][2];
            dp[i][1] %= 9901;

            // dp[i][2] = 오른쪽에 두는 경우 -> 전단계 없는 경우 혹은 왼쪽
            dp[i][2] = dp[i-1][0] + dp[i-1][1];
            dp[i][2] %= 9901;
        }
        int res = (dp[n][0] + dp[n][1] + dp[n][2]) % 9901;
        System.out.println(res);

    }
}
