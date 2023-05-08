package b_19_twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1806 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 선언 및 초기화 부분 */	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0, end = 0;
		
		long min = n+1;
		long sum = a[end];
		for (start = 0; start < n; start++) {
			while (end < n && sum < s) {
				end++;
				if (end!=n) sum += a[end];
			}
			if (end == n) break;
			min = Math.min(min, end-start+1);
			sum -= a[start];
		}
		if (min == n+1) System.out.println("0");
		else System.out.println(min);
		
			
	}
}
