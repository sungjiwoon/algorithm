package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 * ���� �� N�� M 9
 * ���̵� �ǹ� 2
 * Ư¡ : Hashset �Լ� �̿� . �ߺ��� �ɷ����ٴ� ū ������ �ִ�. StringBuilder �� hashset �� ������ ����!
 * ����
	N���� �ڿ����� �ڿ��� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	N���� �ڿ��� �߿��� M���� �� ����
	�Է�
	ù° �ٿ� N�� M�� �־�����. (1 �� M �� N �� 8)
	
	��° �ٿ� N���� ���� �־�����. �Է����� �־����� ���� 10,000���� �۰ų� ���� �ڿ����̴�.
	
	���
	�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.
	
	������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
	
	���� �Է� 1 
	3 1
	4 4 2
	���� ��� 1 
	2
	4
	���� �Է� 2 
	4 2
	9 7 9 1
	���� ��� 2 
	1 7
	1 9
	7 1
	7 9
	9 1
	9 7
	9 9
 */
public class B_15663 {
	static int M, N;
	static int[] nums, arr, before;
	static boolean[] vis;
	static StringBuilder sb;
	static HashSet<String> hs;
	private static void func(int idx, int st) {
		if (idx == M) {
			StringBuilder temp = new StringBuilder();
			
			for (int i = 0; i < M; i++) temp.append(arr[i] + " ");
				
			if (!hs.contains(temp.toString())) {
				sb.append(temp).append("\n");
				hs.add(temp.toString());
			}
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!vis[i]) {
				vis[i] = true;
				arr[idx] = nums[i];
				func(idx+1, i);
				vis[i] = false;
			}
			
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
		hs = new HashSet<>();
		
		vis = new boolean[N+1];
		func(0,0);
		System.out.print(sb);
	}
}
