package b_19_twopointer;

import java.io.*;
import java.util.*;

public class B_22862 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int[] s = new int[n];
		for (int i = 0; i < n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(s);
		
		Queue<Integer> qu = new LinkedList<>();
		
		int start = 0, end;
		while (s[start] % 2 == 1) {
			start++;
		}
		end = start+1;
		int max = 0;
		System.out.println("h2");
		while (end < n) {
			while (qu.size() <= k && end < n) {
				if (s[end] % 2 == 1) {
					qu.add(end);
					System.out.println("qu++");
				} 
				end++;
			}	
			
			System.out.println((end-2) + " - " + start);
			max = Math.max(max, (end-2)-start+1-k);
			start = qu.poll() + 1;
		}
	
		System.out.println(max);
		
			
	}
}
