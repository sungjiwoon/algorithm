package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� �����ϴ� �κ� ���� ����
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	256 MB	126785	50009	32989	37.397%
����
���� A�� �־����� ��, ���� �� �����ϴ� �κ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� A = {10, 20, 10, 30, 20, 50} �� ��쿡 ���� �� �����ϴ� �κ� ������ A = {10, 20, 10, 30, 20, 50} �̰�, ���̴� 4�̴�.

�Է�
ù° �ٿ� ���� A�� ũ�� N (1 �� N �� 1,000)�� �־�����.

��° �ٿ��� ���� A�� �̷�� �ִ� Ai�� �־�����. (1 �� Ai �� 1,000)

���
ù° �ٿ� ���� A�� ���� �� �����ϴ� �κ� ������ ���̸� ����Ѵ�.

���� �Է� 1 
6
10 20 10 30 20 50
���� ��� 1 
4
 */
public class B_11053 {
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
		
		dp[1] = 1; //dp[i] = i��° �ε������� ���� �� ������ ����. 
		for (int i = 2; i <= n; i++) {
			
			int v = values[i];
			dp[i] = 1; //�ϴ� i���� ó������ �ʱ�ȭ.
			for (int j = 1; j < i; j++) {
				if (v > values[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
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
