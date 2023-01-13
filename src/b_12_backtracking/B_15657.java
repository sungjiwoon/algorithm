package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� �� : N�� M 8
 * ���̵� �ǹ� 3
 * ����
	N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. N���� �ڿ����� ��� �ٸ� ���̴�.
	
	N���� �ڿ��� �߿��� M���� �� ����
	���� ���� ���� �� ��� �ȴ�.
	�� ������ �񳻸������̾�� �Ѵ�.
	���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
	�Է�
	ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8)
	
	��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
	
	���
	�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	
	������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	
	���� �Է� 1 
	3 1
	4 5 2
	���� ��� 1 
	2
	4
	5
	���� �Է� 2 
	4 2
	9 8 7 1
	���� ��� 2 
	1 1
	1 7
	1 8
	1 9
	7 7
	7 8
	7 9
	8 8
	8 9
	9 9
 */
public class B_15657 {
	static int M, N;
	static int[] nums, arr;
	static boolean[] vis;
	static StringBuilder sb;
	private static void func(int idx, int st) {
		if (idx == M) {
			for (int i = 0; i < M; i++) sb.append(arr[i] + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = st; i < N; i++) {
			arr[idx] = nums[i];
			func(idx+1, i);
		}
					
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		arr = new int[M+1];
		vis = new boolean[N+1];
		func(0,0);
		System.out.print(sb);
	}
}
