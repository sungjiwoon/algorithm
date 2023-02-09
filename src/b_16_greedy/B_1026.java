package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 보물 성공 (실버 4)
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	2 초	128 MB	46622	30286	25784	67.377%
	문제
	옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
	
	길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
	
	S = A[0] × B[0] + ... + A[N-1] × B[N-1]
	
	S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
	
	S의 최솟값을 출력하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다. N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
	
	출력
	첫째 줄에 S의 최솟값을 출력한다.
	
	예제 입력 1 
	5
	1 1 1 6 0
	2 7 8 3 1
	예제 출력 1 
	18
 */
public class B_1026 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		
		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				if (i == 0)
					a[j] = Integer.parseInt(st.nextToken()); 
				else 
					b[j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += a[i] * b[n-i-1]; //하이 
		}
		System.out.println(ans);
		
		
	}
}
