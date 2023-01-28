package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*1�� ����� 
 * DP �⺻. 
 * ����
���� X�� ����� �� �ִ� ������ ������ ���� �� ���� �̴�.

X�� 3���� ������ ��������, 3���� ������.
X�� 2�� ������ ��������, 2�� ������.
1�� ����.
���� N�� �־����� ��, ���� ���� ���� �� ���� ������ ����ؼ� 1�� ������� �Ѵ�. ������ ����ϴ� Ƚ���� �ּڰ��� ����Ͻÿ�.

�Է�
ù° �ٿ� 1���� ũ�ų� ����, 106���� �۰ų� ���� ���� N�� �־�����.

���
ù° �ٿ� ������ �ϴ� Ƚ���� �ּڰ��� ����Ѵ�.
 */
public class B_1463 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= n; i++) { //i�� 1�� ����� ���� �ʿ��� ���� ��� Ƚ���� �ּڰ�. 
			dp[i] = dp[i-1]+1; 
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			} 			
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			} 
			
		}
		System.out.println(dp[n]);
	}
}
