package b_24_tree;

import java.io.*;
import java.util.*;

/*
 * 트리의 부모노드 (실버2)
 * dfs 이용!
 */
public class B_11725 {
	static int[] arr;
	static HashMap<Integer, ArrayList<Integer>> hs;
	private static void dfs(int p) {
		
		ArrayList<Integer> list = hs.get(p);
		for (int l: list) {
			if (arr[l] == 0) {
				arr[l] = p;
				dfs(l);
			}
		}
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		hs = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			hs.put(i, list);
		}
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = hs.get(a);
			list.add(b);
			hs.put(a, list);
			
			list = hs.get(b);
			list.add(a);
			hs.put(b, list);			
		}
		
		arr = new int[n+1];
		dfs(1);
		
		for (int i = 2; i <= n; i++) {
			System.out.println(arr[i]);
		}
		
		
		
	}
}
