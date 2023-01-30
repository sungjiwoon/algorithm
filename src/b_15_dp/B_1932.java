package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : ���� �ﰢ��
 * ���̵� : �ǹ� 1
 * ����
	        7
	      3   8
	    8   1   0
	  2   7   4   4
	4   5   2   6   5
	�� �׸��� ũ�Ⱑ 5�� ���� �ﰢ���� �� ����̴�.
	
	�� ���� 7���� �����ؼ� �Ʒ��� �ִ� �� �� �ϳ��� �����Ͽ� �Ʒ������� ������ ��, �������� ���õ� ���� ���� �ִ밡 �Ǵ� ��θ� ���ϴ� ���α׷��� �ۼ��϶�. �Ʒ����� �ִ� ���� ���� ������ ���õ� ���� �밢�� ���� �Ǵ� �밢�� �����ʿ� �ִ� �� �߿����� ������ �� �ִ�.
	
	�ﰢ���� ũ��� 1 �̻� 500 �����̴�. �ﰢ���� �̷�� �ִ� �� ���� ��� �����̸�, ������ 0 �̻� 9999 �����̴�.
	
	�Է�
	ù° �ٿ� �ﰢ���� ũ�� n(1 �� n �� 500)�� �־�����, ��° �ٺ��� n+1��° �ٱ��� ���� �ﰢ���� �־�����.
	
	���
	ù° �ٿ� ���� �ִ밡 �Ǵ� ��ο� �ִ� ���� ���� ����Ѵ�.
	
	���� �Է� 1 
	5
	7
	3 8
	8 1 0
	2 7 4 4
	4 5 2 6 5
	���� ��� 1 
	30
 */
public class B_1932 {
	public void work() throws NumberFormatException, IOException {
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
