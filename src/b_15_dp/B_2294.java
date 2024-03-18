package b_15_dp;

import java.io.*;
import java.util.*;
/** 240318 백준 동전 2 골드 5 DP, 배낭 */
public class B_2294 {
    static final int MAX = 2000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tz = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tz.nextToken());
        int k = Integer.parseInt(tz.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1]; //1원일 때의 동전 갯수
        Arrays.fill(dp, MAX);
        for (int i = 0; i < n; i++) {
            if (coins[i] > k) continue;
            dp[coins[i]] = 1;
            for (int j = coins[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }

        if (dp[k] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }



    }
}
