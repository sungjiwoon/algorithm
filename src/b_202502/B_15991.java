package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 250205 1,2,3 더하기 6 실버 1

public class B_15991 {
    static final int INF = 100001;
    public static void main(String[] args) throws Exception {
        int[] dp = new int[INF];

        // 1+x+1 , 2+x+2, 3+x+3 을 추가해주면 된다.
        // 1+1 2+2 3+3 경우의 수만큼 더해준다.

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = dp[2] + 1;
        dp[5] = dp[3] + dp[1];
        dp[6] = dp[4] + dp[2] + 1; // 3+3 추가
        for (int i = 7; i < INF; i++) {
            dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1000000009;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            System.out.println(dp[v]);
        }

    }
}
