package b_15_dp;

import java.io.*;
import java.util.*;

/**
 * 24-02-13 Á¤¼ö »ï°¢Çü DP
 */
public class B_1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[501][501];
		for (int i = 0; i < n; i++) {
			int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < line.length; j++) {
				if (i == 0) {
					dp[i][0] = line[0];
					break;
				}

				if (j == 0) {
					dp[i][j] = dp[i-1][j] + line[j];
					continue;
				}

				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + line[j];
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[n - 1][i]);
		}
		System.out.println(max);
	}
}
