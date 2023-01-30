package b_15_dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : ���� �� ���ϱ� 4
 * ���̵� : �ǹ� 3
 * ����
	�� N���� �־����� ��, i��° ������ j��° ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� ���� ���� N�� ���� ���ؾ� �ϴ� Ƚ�� M�� �־�����. ��° �ٿ��� N���� ���� �־�����. ���� 1,000���� �۰ų� ���� �ڿ����̴�. ��° �ٺ��� M���� �ٿ��� ���� ���ؾ� �ϴ� ���� i�� j�� �־�����.
	
	���
	�� M���� �ٿ� �Է����� �־��� i��° ������ j��° ������ ���� ����Ѵ�.
	
	����
	1 �� N �� 100,000
	1 �� M �� 100,000
	1 �� i �� j �� N
	���� �Է� 1 
	5 3
	5 4 3 2 1
	1 3
	2 4
	5 5
	���� ��� 1 
	12
	9
	1
 */
public class B_11659 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000002];
		int[] dp = new int[1000002];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		//dp[i] = 1~i������ �� 
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int res = dp[b]-dp[a-1];
			System.out.println(res);
		}

	}
}
