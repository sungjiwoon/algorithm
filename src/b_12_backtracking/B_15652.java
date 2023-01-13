package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : N�� M (4) 
 * ���̵� �ǹ� 3
 * ����
	�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	1���� N���� �ڿ��� �߿��� M���� �� ����
	���� ���� ���� �� ��� �ȴ�.
	�� ������ �񳻸������̾�� �Ѵ�.
	���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
	�Է�
	ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
	
	���
	�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	
	������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	
	���� �Է� 1 
	3 1
	���� ��� 1 
	1
	2
	3
	���� �Է� 2 
	4 2
	���� ��� 2 
	1 1
	1 2
	1 3
	1 4
	2 2
	2 3
	2 4
	3 3
	3 4
	4 4
	���� �Է� 3 
	3 3
	���� ��� 3 
	1 1 1
	1 1 2
	1 1 3
	1 2 2
	1 2 3
	1 3 3
	2 2 2
	2 2 3
	2 3 3
	3 3 3
 */
public class B_15652 {
	static int n, m;
	static int[] arr;
	static boolean[] isused;
	static StringBuilder sb;
	private static void func(int idx, int st) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]+ " ");
			}
			sb.append("\n");
			return;
		}
		for (int i = st; i < n; i++) {
				arr[idx] = i+1;
				func(idx+1, i); 
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb= new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m+1];
		isused = new boolean[n+1];
		func(0, 0);
		System.out.print(sb);
	}
}
