package hell_study;

import java.util.*;
import java.io.*;

/** 240218 Four Squares (실버 3) */
public class B_17626 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[50001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j*j]);
            }
            dp[i] = min + 1;
        }

        System.out.println(dp[n]);

        // 26 => 25 + 1 (2)

        // 제곱수 -> 1
        // 제곱수 + 1 -> 2
        // 제곱수 + 2 -> 3
        // 제곱수 + 3 -> 4

        // 제곱수 + dp[4] -> 2
        // 제곱수 + dp[5] -> 3
        // 제곱수 + dp[6] -> 4
        // 제곱수 + dp[7] -> 5
        // 제곱수 + dp[8] -> 4

    }
}
