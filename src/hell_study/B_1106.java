package hell_study;

import java.io.*;
import java.util.*;
/** 240307 백준 호텔 DP, 배낭 골드5 */
public class B_1106 {
    static final int MAX = 20000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); //가격
            arr[i][1] = Integer.parseInt(st.nextToken()); //인원
        }

        int[] dp = new int[2010];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        // dp[i] = i명을 홍보할 때의 최소 비용.

        for (int i = 0; i < n; i++) {
            int cost = arr[i][0], p = arr[i][1];

            for (int j = 0; j < (double) (c / p) + 1; j++) {
                for (int k = 1; k <= p; k++) {
                    int idx = (j * p) + k;
                    if (idx-p >= 1) dp[idx] = Math.min(dp[idx], dp[idx-p] + cost);
                    else dp[idx] = Math.min(dp[idx], (j+1) * cost);

                    System.out.println(String.format("dp[%d] = %d", idx, dp[idx]));
                }

            }
            System.out.println();
        }
        System.out.println(dp[c]);

    }
}
