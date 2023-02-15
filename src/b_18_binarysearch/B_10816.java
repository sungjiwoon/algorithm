package b_18_binarysearch;

import java.io.*;
import java.util.*;
/*
 * 숫자 카드 2 성공 실버4
 * 
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	98109	36708	26284	36.459%
문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

예제 입력 1 
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10
예제 출력 1 
3 0 0 1 2 0 0 2
 */
public class B_10816 {
	static long[] a; 
	/* 이분 탐색 시 반복문에서 무한루프 빠지지않게 조심하자. st=mid 되는 순간 되부분 무한루프이다!! */
	private static int upper(int st, int en, long k) {
		while (st < en) { //같아지는 순간에 return
			int mid = (st+en) / 2;
			if (a[mid] > k) en = mid;
			else st = mid+1;
		}
		return st;
	}
	
	private static int lower(int st, int en, long k) {
		while (st < en) { //같아지는 순간에 return
			int mid = (st+en) / 2;
			if (a[mid] >= k) en = mid;
			else st = mid+1;
		}
		return en;
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
			
			int start = upper(0, n, k);
			int end = lower(0, n, k);
			System.out.print(Math.abs(end-start) + " ");
		}					
			
	}
}
