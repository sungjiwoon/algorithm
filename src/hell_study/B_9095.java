package hell_study;

import java.io.*;
import java.util.*;

/**
 * 24-02-13 화 1,2,3 더하기 DP
 */
public class B_9095 {

    public static void main(String[] args) {

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }

    /**
     * 1 : 1 (1)
     * 2 : 11, 2 (2)
     * 3 : 111, 21, 12, 3 (4)
     * 4 : 1111, 211, 121, 112, 31, 13, 22 (7)
     * 5 : 11111, 2111, 1211, 311, 221, 23, 122 (5)
     * 1, 2, 3 으로 이루어졌다는 것은
     * dp[i] 는
     * i-1에서 각 원소(?)에 1을 더한것과
     * i-2에서 각 원소에 2를 더한것과
     * i-3에서 각 원소에 3을 더한것과 같다.
     * 즉 dp[i] = dp[i-1] + dp[i-2] + dp[i-3] 이다.
     */
}
