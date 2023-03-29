package b_18_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10815 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(a);
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			long k = Long.parseLong(st.nextToken());
			
			if (Arrays.binarySearch(a, k) >= 0) sb.append("1 ");
			else sb.append("0 ");
		}		
		System.out.println(sb);
			
	}
}
