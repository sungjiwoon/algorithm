package hell_study;

import java.io.*;
import java.util.*;
/** 240315 백준 도로의 갯수 골드 5 DP */
public class B_1577 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][m+1];
        boolean[][] hor = new boolean[n][m+1]; //가로 부실 공사
        boolean[][] ver = new boolean[n+1][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (a == c) {
                ver[a][Math.min(b,d)] = true; // 세로 도로 부실공사
            } else {
                hor[Math.min(a,c)][b] = true; // 가로 도로 부실 공사
            }
        }

        for (int i = 1; i <= n; i++) {
          if (hor[i-1][0]) break;
          dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            if (ver[0][i-1]) break;
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                if (ver[i][j-1]) {
                    dp[i][j] -= dp[i][j-1];
                }

                if (hor[i-1][j]) {
                    dp[i][j] -= dp[i-1][j];
                }

            }
        }
        System.out.println(dp[n][m]);

    }
}
