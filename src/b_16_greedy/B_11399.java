package b_16_greedy;

import java.io.*;
import java.util.*;
/* ������ : ATM 
 * ���̵� �ǹ� 4
 * �׸��� �˰����� 
 * �����ϰ� Ǯ�� ����. 
 * 
 * ����
	�������࿡�� ATM�� 1��ۿ� ����. ���� �� ATM�տ� N���� ������� ���� ���ִ�. ����� 1������ N������ ��ȣ�� �Ű��� ������, i�� ����� ���� �����ϴµ� �ɸ��� �ð��� Pi���̴�.
	
	������� ���� ���� ������ ����, ���� �����ϴµ� �ʿ��� �ð��� ���� �޶����� �ȴ�. ���� ���, �� 5���� �ְ�, P1 = 3, P2 = 1, P3 = 4, P4 = 3, P5 = 2 �� ��츦 �����غ���. [1, 2, 3, 4, 5] ������ ���� ���ٸ�, 1�� ����� 3�и��� ���� ���� �� �ִ�. 2�� ����� 1�� ����� ���� ���� �� ���� ��ٷ��� �ϱ� ������, 3+1 = 4���� �ɸ��� �ȴ�. 3�� ����� 1��, 2�� ����� ���� ���� ������ ��ٷ��� �ϱ� ������, �� 3+1+4 = 8���� �ʿ��ϰ� �ȴ�. 4�� ����� 3+1+4+3 = 11��, 5�� ����� 3+1+4+3+2 = 13���� �ɸ��� �ȴ�. �� ��쿡 �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� 3+4+8+11+13 = 39���� �ȴ�.
	
	���� [2, 5, 1, 4, 3] ������ ���� ����, 2�� ����� 1�и���, 5�� ����� 1+2 = 3��, 1�� ����� 1+2+3 = 6��, 4�� ����� 1+2+3+3 = 9��, 3�� ����� 1+2+3+3+4 = 13���� �ɸ��� �ȴ�. �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� 1+3+6+9+13 = 32���̴�. �� ������� �� �ʿ��� �ð��� ���� �ּҷ� ���� ���� ����.
	
	���� �� �ִ� ����� �� N�� �� ����� ���� �����ϴµ� �ɸ��� �ð� Pi�� �־����� ��, �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� ����� �� N(1 �� N �� 1,000)�� �־�����. ��° �ٿ��� �� ����� ���� �����ϴµ� �ɸ��� �ð� Pi�� �־�����. (1 �� Pi �� 1,000)
	
	���
	ù° �ٿ� �� ����� ���� �����ϴµ� �ʿ��� �ð��� ���� �ּڰ��� ����Ѵ�.
	
	���� �Է� 1 
	5
	3 1 4 3 2
	���� ��� 1 
	32
 */
public class B_11399 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] dp = new int[n+1];
		dp[1] = arr[1];
		int sum = dp[1];
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + arr[i];
			sum += dp[i];
		}
		System.out.println(sum);
		
	}
}