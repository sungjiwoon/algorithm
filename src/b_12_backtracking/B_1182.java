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
	private static void func(int idx, int count) {
		if (idx == n) {
			if (count==s) cnt++;
			return;
		}
		
		func(idx+1, count+arr[idx]);
		func(idx+1, count);
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		map = new int[n];
		vis = new boolean[n];
		arr = new int[n+1];
		map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		func(0,0);
		if (s == 0) cnt--;
		System.out.println(cnt);
	}
}
