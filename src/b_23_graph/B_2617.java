package b_23_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B_2617 {

	public void work() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] heavy = new int[n+1]; //heavy[i] = j -> i는 j보다 무거움. 
		int[] light = new int[n+1]; //light[j] = i -> j는 i보다 가벼움. 
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a > b
			heavy[a] = b;
			light[b] = a;
		}
		
		for (int i = 1; i <= n; i++) {
			
		}
		
//		System.out.println(cnt);
		
		
	}
}
