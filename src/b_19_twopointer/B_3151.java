package b_19_twopointer;

import java.io.*;
import java.util.*;
/*
 * 합이 0
 * 4초
 * 
 */
public class B_3151 {
	static int n;
	static int[] borad;
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer sto = new StringTokenizer(br.readLine(), " ");
		borad = new int[n];
		
		for (int j = 0; j < n; j++) borad[j] = Integer.parseInt(sto.nextToken());
		
		Arrays.sort(borad);
		long ans = 0;
		for (int i = 0; i < n-2; i++) {
			int fix = i; //첫번째 값. 
			if (borad[fix] > 0) break;
			int st = fix+1; //두번째 값.
			int en = n-1; //세번째 값. 
			
			while (st < en) {
				int st_n = 1;
				int en_n = 1;
				
				int sum = borad[fix] + borad[st] + borad[en];
				if (sum == 0) {
					if (borad[st] == borad[en]) {
						int tmp = en-st+1;
						ans += (tmp*(tmp-1)/2);
						/*
						 * -10 5 5 5 5 5 -> 5가 여러번 반복되므로, 
						 * 5C2가 ans가 된다.
						 */
						break;
					}
					
					while (st+1 < en && borad[st] == borad[st+1]) {
						st_n++;
						st++;
					} //st의 다음 값이 같을 경우
					
					while (st < en-1 && borad[en] == borad[en-1]) {
						en_n++;
						en--;
					} //en의 다음 값이 같을 경우. 
					ans += st_n*en_n;
				}
				
				if (sum < 0) { //음수가 더 크면, 값이 더 작은 st의 값을 올린다. 
					st++;
				} else en--; //반대. 
			}
		}
		
		System.out.println(ans);
	
	}
	
	/*
	 * 최대 경우의 수가 존재할 때는 N 이 10000이고 배열이 모두 0으로 주어진 경우이다.

	이 때 경우의 수는 10000C3 = 166,616,670,000이므로 long타입으로 정답을 출력해야 한다.

	입력값을 오름차순으로 정렬한다.
	<투포인터>
	가장 작은 값(0번 인덱스)을 fix 시키고 1번인덱스와 마지막 인덱스를 start, end로 놓는다.
	배열의 0, start, end의 값이 0인지 확인한다
	합이 0보다 크면 end를 줄인다, 0보다 작거나 같으면 start를 늘린다.
	 */
}
