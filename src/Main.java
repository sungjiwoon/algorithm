import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[501][501];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int j = 1;
			while (st.hasMoreTokens()) {
				arr[i][j++] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[501][501];
		dp[1][1] = arr[1][1];
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j > 1)
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
				else if (j == 1) {
					dp[i][j] = dp[i-1][j] + arr[i][j];
				} else if (j == i){
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				}
			}
		}
		
		int best = 0;
		for (int i = 1; i <= n; i++) {
			if (best < dp[n][i]) best = dp[n][i];
		}
		System.out.println(best);
	}
	
}
