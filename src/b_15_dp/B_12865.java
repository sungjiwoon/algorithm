package b_15_dp;

import java.io.*;
import java.util.*;

/** 240220 백준 평범한 배낭 골드 5 DP */

public class B_12865 {
    static int n, k;
    static int[][] things;

    private static int solve() {
        Arrays.sort(things, (o1, o2) -> o1[0] - o2[0]);

        int res = 0;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j - things[i][0] >= 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - things[i][0]] + things[i][1]);
                }
            }
        }

        for (int i = 0; i <= k; i++) {
            res = Math.max(dp[n][i], res);
        }


        return res;
    }
    public static void main(String[] args)  {
        input();
        System.out.println(solve());
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            k = tmp[1];
            things = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                things[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }
}
