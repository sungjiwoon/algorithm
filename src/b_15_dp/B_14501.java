package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14501 {
	//����.. ���� ������ �Ф�
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[17+n];
		int[] prices = new int[17+n];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken()); 
			prices[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[17+n]; //i�� �ִ� ����  
		int max = 0;
		
		for (int i = 1; i <= n+1; i++) {
			
			dp[i] = Math.max(dp[i], max);
			dp[t[i] + i] = Math.max(dp[t[i]+i], prices[i]+dp[i]);
			max = Math.max(max,  dp[i]);
			
				
		}
		System.out.println(max);
		
		
	}
}
