package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : ���� �� 
 * ���̵� : �ǹ� 2
 * ����
	n���� ������ �̷���� ������ ������ �־�����. �츮�� �� �� ���ӵ� �� ���� ���� �����ؼ� ���� �� �ִ� �� �� 
	���� ū ���� ���Ϸ��� �Ѵ�. ��, ���� �� �� �̻� �����ؾ� �Ѵ�.
	
	���� �� 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 �̶�� ������ �־����ٰ� ����. 
	���⼭ ������ 12+21�� 33�� ������ �ȴ�.
	
	�Է�
	ù° �ٿ� ���� n(1 �� n �� 100,000)�� �־����� ��° �ٿ��� n���� ������ �̷���� ������ �־�����. 
	���� -1,000���� ũ�ų� ����, 1,000���� �۰ų� ���� �����̴�.
	
	���
	ù° �ٿ� ���� ����Ѵ�.
	
	���� �Է� 1 
	10
	10 -4 3 1 5 6 -35 12 21 -1
	���� ��� 1 
	33
 */
public class B_1912 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[100001];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] dp = new long[n+1];
		long mx = arr[1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]); //i��°���� �� �� ū ��. 
			mx = Math.max(dp[i], mx); //���ݱ����� �ִ� ��. 
		}
		System.out.println(mx);
	}
}
