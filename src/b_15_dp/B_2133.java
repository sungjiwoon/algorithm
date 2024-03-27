package b_15_dp;

import java.io.*;
import java.util.*;

public class B_2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[4][31];
        for (int j = 2; j <= 30; j += 2) {
            dp[1][j] = 1;
        }
        dp[2][1] = 1;
        dp[2][2] = 2;
        for (int i = 2; i <= 3; i++) {
//            dp[i][1] =
            for (int j = 1; j <= 30; j++) {

            }
        }
    }
}
