package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� �� N�� M 7
 * ���̵� : �ǹ� 3
 * ����
	N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. N���� �ڿ����� ��� �ٸ� ���̴�.
	
	N���� �ڿ��� �߿��� M���� �� ����
	���� ���� ���� �� ��� �ȴ�.
	�Է�
	ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 7)
	
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
	7 1
	7 7
	7 8
	7 9
	8 1
	8 7
	8 8
	8 9
	9 1
	9 7
	9 8
	9 9
 */
public class B_15656 {
	static int m, n;
	static int[] arr, nums;
	static boolean[] vis;
	static StringBuilder sb;
	private static void func(int idx, int st) {
		if (idx == m) {
			for(int i = 0; i < m; i++ ) sb.append(arr[i]+" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < n; i++ ) {
			arr[idx] = nums[i];
			func(idx+1, i);
		
		}
	}
	public void work () throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m+1];
		vis = new boolean[n+1];
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		func(0,0);
		System.out.print(sb);
	}
}
