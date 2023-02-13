package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 소수 구하기 성공
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	226055	64145	45144	26.587%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16
예제 출력 1 
3
5
7
11
13

** 기존 풀이법이 아닌 state 배열을 써줌으로써 시간을 절약함. 
 */
public class B_1929 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		boolean[] state = new boolean[n+1]; //false => 소수. 
		
		Arrays.fill(state, true);
		state[1] = false;
		
		for (int i = 2; i * i <= n; i++) {
			if (!state[i]) continue;
			for (int j = i*i; j <= n; j+=i) {
				state[j] = false;

			}
		}
		for (int i = m; i <= n; i++) {
			if (state[i]) System.out.println(i);
		}
		
		
	}
}
