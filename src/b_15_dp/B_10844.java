package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : ���� ��� �� 
 * ���̵� : �ǹ� 1
 * ����
	45656�̶� ���� ����.
	�� ���� ������ ��� �ڸ��� ���̰� 1�̴�. �̷� ���� ��� ����� �Ѵ�.
	
	N�� �־��� ��, ���̰� N�� ��� ���� �� �� �� �ִ��� ���غ���. 0���� �����ϴ� ���� ��ܼ��� �ƴϴ�.
	
	�Է�
	ù° �ٿ� N�� �־�����. N�� 1���� ũ�ų� ����, 100���� �۰ų� ���� �ڿ����̴�.
	
	���
	ù° �ٿ� ������ 1,000,000,000���� ���� �������� ����Ѵ�.
	
	���� �Է� 1 
	1
	���� ��� 1 
	9
	���� �Է� 2 
	2
	���� ��� 2 
	17
 */
public class B_10844 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[101][10];
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= n; i++) {
			
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j+1] % 1000000000;
				} else if (j == 9) {
					dp[i][j] = dp[i-1][j-1] % 1000000000;
				} else {
					dp[i][j] = dp[i-1][j-1] % 1000000000 +dp[i-1][j+1] % 1000000000;
				}
			}
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum += dp[n][i];
		}
		
		System.out.println(sum % 1000000000);
		
		
	}
}
