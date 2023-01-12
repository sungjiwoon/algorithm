package b_12_backtracking;

import java.util.Scanner;

/* 문제명 : N과 M 2
 * 난이도 : 실버 3
 * 백트래킹 기본 문제 
 * 문제
	자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	
	1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	고른 수열은 오름차순이어야 한다.
	
	입력
	첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
	
	출력
	한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
	
	수열은 사전 순으로 증가하는 순서로 출력해야 한다.
	
	예제 입력 1 
	3 1
	예제 출력 1 
	1
	2
	3
	예제 입력 2 
	4 2
	예제 출력 2 
	1 2
	1 3
	1 4
	2 3
	2 4
	3 4
	예제 입력 3 
	4 4
	예제 출력 3 
	1 2 3 4
 */

public class B_15650 {
	static int n, m;
	static int[] arr;
	static boolean[] isused;
	private static void func(int idx, int st) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		
		for (int i = st; i < n; i++) {
			if (!isused[i]) {
				isused[i] = true;
				arr[idx] = i+1;
				func(idx+1, i+1);
				isused[i] = false;
			}
		}
	}
	public void work() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		isused = new boolean[n];
		func(0, 0);
	}
}
