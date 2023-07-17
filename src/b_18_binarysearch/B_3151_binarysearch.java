package b_18_binarysearch;

import java.io.*;
import java.util.*;
/*
 * 합이 0
 * 4초
 * 
 */
public class B_3151_binarysearch {
	static int n;
	static int[] borad;
	private static int lower_bound(int start, int target) {
		int begin = start;
		int end = n;
		while (begin < end) {
			int mid = (begin + end) /2;
			//System.out.println(target + ":: " + mid);
			if (mid < n && borad[mid] < target) begin = mid+1;
			else end = mid;
		}
		return end;
	}
	
	private static int upper_bound(int start, int target) {
		int begin = start;
		int end = n;
		while (begin < end) {
			int mid = (begin + end) /2;
			//System.out.println(target + ":: " + mid);
			if (mid < n && borad[mid] <= target) begin = mid+1;
			else end = mid;
		}
		return end;
		
	}
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
			for (int j = i+1; j < n-1; j++) {
				int sum = borad[i] + borad[j];
				int lo = lower_bound(j+1,-1 * sum);
				int up = upper_bound(j+1,-1 * sum);
				//값이 없으면 lo == up 같아짐. 
				//if (lo == -1 || up == -1) continue;
				ans += up-lo;
			}
			
		}

		/*
		두 명을 선택하고 나머지 한 명을 이분탐색으로 찾되 여러 개 있는 경우를
		고려하여 upper_bound와 lower_bound를 이용한다.
		0  1  2  3  4  5  6  7
		13 13 15 17 17 17 17 18
		lower_bound : 3
		upper_bound : 7
		*/
		
		
		System.out.println(ans);
	
	}
	
	
}
