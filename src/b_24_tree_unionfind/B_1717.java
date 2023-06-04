package b_24_tree_unionfind;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * 유니온 파인드를 이용한 문제!!
 */
public class B_1717 {
	static int n, m;
	static int[] parent;
	static int find(int x) {
		if (parent[x] == x || parent[x] == -1) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void merge(int x, int y) {
		int xx = find(x);
		int yy = find(y);
		parent[yy] = xx;
	}
	
	static boolean isUnion(int x, int y) {
		int xx = find(x);
		int yy = find(y);
		if (xx==yy) return true;
		return false;
	}
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		Arrays.fill(parent, -1);
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int ok = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (ok == 0) { //합집합.
				merge(x,y);
			} else {
				if (isUnion(x,y)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb);
		
	}
}








