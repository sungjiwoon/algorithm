package b_12_backtracking;

import java.util.Scanner;
/*문제 : N-Queen
 * 문제 난이도 골드 4
 * 백트래킹 어렵다.. 
 * 문제
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1 
8
예제 출력 1 
92


 */
public class B_9663 {
	static int n;
	static boolean[] isused1 = new boolean[40], 
			isused2 = new boolean[40], 
			isused3 = new boolean[40];
	static int cnt = 0;
	private static void func(int idx) {
		if (idx == n) {
			cnt++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isused1[i] || isused2[i+idx] || isused3[idx-i+n-1]) continue;
			isused1[i] = true;
			isused2[i+idx] = true;
			isused3[idx-i+n-1] = true;
			func(idx+1);
			isused1[i] = false;
			isused2[i+idx] = false;
			isused3[idx-i+n-1] = false;
			
		}
	}
	public void work() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		func(0);
		System.out.println(cnt);
		
		
	}
}
