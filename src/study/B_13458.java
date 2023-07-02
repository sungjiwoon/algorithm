package study;

import java.io.*;
import java.util.*;

//삼성 역량 SW 기초. 
public class B_13458 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long res = 0;
		
		for (int i = 0; i < n; i++) {
			long v = 0;
			int tmp = a[i] - b; 
			v++;
			if (tmp <= 0) continue;
			else {
				v += Math.ceil((double)tmp / c);
			}
			res += v;
			
		}
		
		System.out.println(res);
		
	}
}



