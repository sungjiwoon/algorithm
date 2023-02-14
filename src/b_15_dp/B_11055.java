package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� ū ���� �κ� ���� (�ǹ� 2)
	����
	���� A�� �־����� ��, �� ������ ���� �κ� ���� �߿��� ���� ���� ū ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	���� ���, ���� A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} �� ��쿡 ���� ���� ū ���� �κ� ������ A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} �̰�, ���� 113�̴�.
	
	�Է�
	ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.
	
	��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)
	
	���
	ù° �ٿ� ���� A�� ���� ���� ū ���� �κ� ������ ���� ����Ѵ�.
	
	���� �Է� 1 
	10
	1 100 2 50 60 3 5 6 7 8
	���� ��� 1 
	113
 */
public class B_11055 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] values = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			values[i] = Integer.parseInt(st.nextToken()); 
		}
		dp[1] = values[1];
		for (int i = 2; i <= n; i++) {
			
			dp[i] = values[i];
			for (int j = 1; j < i; j++) {
				if (values[i] > values[j]) {
					dp[i] = Math.max(dp[j]+values[i], dp[i]);
				}
			}
				
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (dp[i] > max) max = dp[i];
		}
		System.out.println(max);
		
		
	}
}