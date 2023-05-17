package b_15_dp;

import java.io.*;
import java.util.Arrays;
/*
 * �������� �� ����
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	128 MB	52612	21211	15416	39.378%
����
� �ڿ��� N�� �׺��� �۰ų� ���� ���������� ������ ��Ÿ�� �� �ִ�. 
���� ��� 11=32+12+12(3�� ��)�̴�. �̷� ǥ������� ���� ������ �� �� �ִµ�,
11�� ��� 11=22+22+12+12+12(5�� ��)�� �����ϴ�. �� ���, ������ ��ũ���׽��� ��11�� 3�� ���� ������ ������ ǥ���� �� �ִ�.����� ���Ѵ�. ���� 11�� �׺��� ���� ���� ������ ������ ǥ���� �� �����Ƿ�, 11�� �� �����ν� ǥ���� �� �ִ� ������ ���� �ּ� ������ 3�̴�.

�־��� �ڿ��� N�� �̷��� ���������� ������ ǥ���� ���� �� ���� �ּҰ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */
public class B_1699 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		Arrays.fill(dp, 100000);
		dp[0] = 0;
		dp[1] = 1;
		int rt = 1;		
		
		for (int i = 2; i <= n; i++) {
			
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		//128 -> 64+64 �� �ּڰ���!!!!! 
		System.out.println(dp[n]);	
		
				
	}
}
