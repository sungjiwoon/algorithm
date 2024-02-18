package hell_study;

import java.util.*;
import java.io.*;

/** 240218 Four Squares (실버 3) */
public class B_17626 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;

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
