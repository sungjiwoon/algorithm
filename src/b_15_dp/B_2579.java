package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1]; 
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//i��° ��ܱ��� �ö��� �� ���� ���� ����� ���� �ּڰ�, 
		//�� i��° ����� �ݵ�� ���� ���� ���.	�׷��� i-1 ����� ������ ��ƾ���. 	
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = arr[1]; //1�� �ȹ���
		dp[2] = arr[2];  //2�� �ȹ���.
		dp[3] = arr[3]; //3 �� ���, 1 2 ��� ����. 
		for (int i = 4; i <= n-1; i++) {
			dp[i] = Math.min(dp[i-2], dp[i-3]) + arr[i];
		}
		dp[n] -= Math.min(dp[n-2], dp[n-3]);
		System.out.println(dp[n]);
	}
}
