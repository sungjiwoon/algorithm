import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] R = new int[n+1];
		int[] G = new int[n+1];
		int[] B = new int[n+1];
		
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			R[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[n+1][3];
		
		/*
		 * dp[i][0] = i��° ���� ĥ�ϴµ�, �ּڰ� �� i�� ����
		 * dp[i][1] = i��° ���� ĥ�ϴµ�, �ּڰ� �� i�� �׸�
		 * dp[i][2] = i��° ���� ĥ�ϴµ�, �ּڰ� �� i�� ���
		 */
		
		//i��° ��ܱ��� �ö��� �� ���� ���� ����� ���� �ּڰ�, 
		//�� i��° ����� �ݵ�� ���� ���� ���.	�׷��� i-1 ����� ������ ��ƾ���. 	
		dp[1][0] = R[1]; //R�� ĥ��
		dp[1][1] = G[1];  //G�� ĥ��
		dp[1][2] = B[1]; //B�� ĥ��
		
		for (int i = 2; i <= n; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + R[i];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + G[i];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + B[i];
		}
		
		int best = dp[n][0];
		for (int i = 0; i < 3; i++) {
			if (best > dp[n][i]) best = dp[n][i];
		}

		System.out.println(best);
	}
	
}
