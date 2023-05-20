package swexpert;

import java.io.*;
import java.util.*;
/*
 * 각 구역의 최댓값. 
 */
public class S_1209 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = 0;
		while (t < 10) {
			t = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int res = 0;
			
			int[][] dp = new int[101][101];
			int[][] dp2 = new int[101][101];
			int max1 = 0;
			int max2 = 0;
			
			//가로
			for (int i = 0; i < 100; i++) {
				dp[i][0] = arr[i][0];				
				for (int j = 1; j < 100; j++) {
					dp[i][j] = dp[i][j-1] + arr[i][j];
				}
				max1 = Math.max(max1, dp[i][99]);
			}
			//새로
			for (int i = 0; i < 100; i++) {
				dp2[0][i] = arr[0][i];
				for (int j = 1; j < 100; j++) {
					dp2[j][i] = dp2[j-1][i] + arr[j][i];
				}
				max2 = Math.max(max2, dp2[99][i]);
			}
			
			//대각선. 
			int max3 = 0;
			int max4 = 0;
			for (int i = 0; i < 100; i++) {
				max3 += arr[i][i];
				max4 += arr[i][99-i];
			}
			
			res = Math.max(max1, max2);
			res = Math.max(res, max3);
			res = Math.max(res, max4);
			
			sb.append("#").append(t).append(" " + res).append("\n");
		}
		System.out.println(sb);
	}
}
