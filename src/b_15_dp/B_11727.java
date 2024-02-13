package b_15_dp;

import java.util.*;
import java.io.*;

/**
 * 24-02-13 화 2xn 타일링 2 DP
 */
public class B_11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + (dp[i-2] * 2);
            dp[i] %= 10007;
        }

        System.out.println(dp[n]);

    }
}
