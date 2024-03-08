package hell_study;

import java.io.*;
import java.util.*;
/** 240308 백준 최대 페이지 수 실버 2 DP, 배낭 */
public class B_16493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] bookDay = new int[m][2];
        for (int i = 0; i < m; i++) {
            bookDay[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dp = new int[n+1]; // dp[i] i일자에 읽을 수 있는 책의 최대 페이지 수

        for (int i = 0; i < m; i++) {
            int day = bookDay[i][0], page = bookDay[i][1];

            for (int j = n; j >= day; j--) {
                dp[j] = Math.max(dp[j], dp[j - day] + page);
            }

        }
        System.out.println(dp[n]);
    }
}
