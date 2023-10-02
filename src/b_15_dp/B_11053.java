package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	public static void main(String[] args)  throws IOException {
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

		Arrays.fill(dp, 1);
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				if (values[j] < values[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());
		
	}
}
