package b_18_binarysearch;

import java.io.*;
import java.util.*;
/*
 * 수 찾기 성공 실버 4 / 이분탐색
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	186953	56392	37459	29.867%
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

예제 입력 1 
5
4 1 5 2 3
5
1 3 7 9 5
예제 출력 1 
1
1
0
0
1
 */
public class B_1920 {
	static long[] a;

	private static int binary_search(int start, int end, long k) {
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (a[mid] < k) {
				start = mid+1;
			} else if (a[mid] > k) {
				end = mid-1;
			} else 
				return 1;
		} 
		return 0;
			
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		
		int n = Integer.parseInt(br.readLine());
		a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < m; i++) {
			long k = Long.parseLong(st.nextToken());
			System.out.println(binary_search(0, n-1, k));
		}					
			
	}
}
