package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : 2x1 Ÿ�ϸ� 
 * ���̵� : �ǹ� 3
 * ����
	2��n ũ���� ���簢���� 1��2, 2��1 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� n�� �־�����. (1 �� n �� 1,000)
	
	���
	ù° �ٿ� 2��n ũ���� ���簢���� ä��� ����� ���� 10,007�� ���� �������� ����Ѵ�.
	
	���� �Է� 1 
	2
	���� ��� 1 
	2
	���� �Է� 2 
	9
	���� ��� 2 
	55
 */
public class B_11726 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		//i��° ��ܱ��� �ö��� �� ���� ���� ����� ���� �ּڰ�, 
		//�� i��° ����� �ݵ�� ���� ���� ���.	�׷��� i-1 ����� ������ ��ƾ���. 	
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i-1]+dp[i-2];
			dp[i] %= 10007;
		}
		System.out.println(dp[n]);

	}
}
