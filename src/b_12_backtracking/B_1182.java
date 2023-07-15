package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 문제 : 부분 수열의 합 
 * 난이도 : 실버 2
 * 문제
	N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 
	둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 
	주어지는 정수의 절댓값은 100,000을 넘지 않는다.
	
	출력
	첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
	
	예제 입력 1 
	5 0
	-7 -3 -2 5 8
	예제 출력 1 
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
