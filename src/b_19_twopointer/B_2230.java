package b_19_twopointer;

import java.io.*;
import java.util.*;
/*
 * 수 고르기 성공
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	2 초	128 MB	14680	4829	3387	30.352%
	문제
	N개의 정수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 
	이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다), 
	그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.
	
	예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 
	만약 M = 3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다. 
	이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.
	
	입력
	첫째 줄에 두 정수 N, M이 주어진다. 
	다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.
	
	출력
	첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.
	
	예제 입력 1 
	3 3
	1
	5
	3
	예제 출력 1 
	4
 */
public class B_2230 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		
		int start = 0, end = 1;
		long min = Long.MAX_VALUE;
		
		while (start < n && end < n) {
			
			while (Math.abs(a[end]-a[start]) < m) {
				if (end == n-1) break;
				end++;
				//System.out.println(end);
			}
			if (a[end]-a[start] == m) {
				min = m;
				break;
			} else if (a[end]-a[start] > m) {
				min = Math.abs(a[end]-a[start]);
			}
			start++;
			//System.out.println(a[start] + "," + a[end]);
			
		}
		System.out.println(min);
		
			
	}
}
