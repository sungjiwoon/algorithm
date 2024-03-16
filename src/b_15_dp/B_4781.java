package b_15_dp;
import java.io.*;
import java.util.*;

/** 240316 백준 사탕 가게 골드4 DP, 배낭 */
public class B_4781 {

    static int n;
    static double m;
    static int[][] candy;

    private static int solve() {
        int max = 0;
        int money = (int) (m * 100);

        int[] dp = new int[money + 1]; //1원당 구매할 수 있는 가장 높은 칼로리

        for (int i = 0; i < n; i++ ) {
            int cal = candy[i][0], price = candy[i][1];
            for (int j = price; j + price <= money; j++) {
                dp[j] = Math.max(dp[j-price] + cal, dp[j]);
                System.out.println(String.format("dp[%d] = %d", j, dp[j]));
                max = Math.max(dp[j], max);
            }
            System.out.println();
        }

        return max;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Double.parseDouble(st.nextToken());
            if (n == 0) break;

            candy = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                double p  = Double.parseDouble(st.nextToken());
                candy[i][0] = c;
                candy[i][1] = (int) (p * 100);
            }

            sb.append(solve()+"\n");
        }
        System.out.println(sb);
    }
}
