package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� : �κ� ������ �� 
 * ���̵� : �ǹ� 2
 * ����
	N���� ������ �̷���� ������ ���� ��, ũ�Ⱑ ����� �κм��� �߿��� �� ������ ���Ҹ� �� ���� ���� S�� �Ǵ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� ������ ������ ��Ÿ���� N�� ���� S�� �־�����. (1 �� N �� 20, |S| �� 1,000,000) 
	��° �ٿ� N���� ������ �� ĭ�� ���̿� �ΰ� �־�����. 
	�־����� ������ ������ 100,000�� ���� �ʴ´�.
	
	���
	ù° �ٿ� ���� S�� �Ǵ� �κм����� ������ ����Ѵ�.
	
	���� �Է� 1 
	5 0
	-7 -3 -2 5 8
	���� ��� 1 
	1
 */
public class B_1182 {
	static int n, s;
	static int[] map;
	static boolean[] vis;
	static int[] arr;
	static int cnt = 0;
	private static void func(int idx, int size, int nxt) {
		if (idx == size) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				sum += arr[i];
			}
			
			if (sum == s) {
				System.out.println(Arrays.toString(arr));
				cnt++;
			}
			return;
		}
		
		for (int i = nxt; i < n; i++) {
			arr[idx] = map[i];
			func(idx+1, size, i+1);
		}
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		map = new int[n];		
		vis = new boolean[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i= 0; i < n; i++) map[i] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			arr = new int[i];
			func(0,i,0);
		}
		System.out.println(cnt);
	}
}
