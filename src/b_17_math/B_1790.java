package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1790 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		String s = "";
//		1~9 : 1*9
//		
//		10~99 : 2*10*9
//		100~109 : 100 101 102 109 -> 3 * 10
//		100~199 : 3 * 10 * 10 //100 110 120 130 140 150 160 170 180 190 
//		100~999 : 3 * 10 * 10 * 9 //100 200 300 400 500 600 700 800 900
//		
//		만약 23번째 -> 9<23<180 
		long l = 1, be = 1; 
		for (int i = 1; i <= 9; i++) {
			be = l;
			l += (long) (i * Math.pow(10,i-1) * 9);
			if (be < k && k <= l) {
				while (be < k && k <= l) {
					long a = l / 2;
					if (be < n && n < a) {
						l = a;
					} else {
						be = a+1;
					}				
				}
				
				
				
			}			
			
		}
		
	}
}
