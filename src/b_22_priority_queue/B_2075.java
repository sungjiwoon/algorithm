package b_22_priority_queue;

import java.io.*;
import java.util.*;
/*
 * N번째 큰수, 실버 2, 1초 
 * 
 */
public class B_2075 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int k =  Integer.parseInt(st.nextToken());
				qu.add(k);
			}
		}
		
		for (int i = 0; i < n-1; i++) {
			qu.poll();
		}
		System.out.println(qu.poll());
	}
}
