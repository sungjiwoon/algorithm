package b_24_tree;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * ��� ������ �Ÿ�... ��� 5
 * ���� �湮 ǥ�� �� �Ű澲�� !!!!!!!!!!!!!!!!!
 * 
 * N(2��N��1,000)���� ���� �̷���� Ʈ���� �־����� M(M��1,000)���� �� ��� ���� �Է¹��� �� �� ��� ������ �Ÿ��� ����϶�.
 * 
 * 
 */
public class B_1240 {
	static int n,m;
	static HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
	static long[][] value;
	private static void dfs(int st, int mid, int en, boolean[] vis) {
		//st -> ������ 
		//en -> ������ ��.
		//cnt -> �Ÿ�
		
		ArrayList<Integer> list = hs.get(mid);
		for (int l:list) {
			if (st == l || vis[l]) continue;
			//System.out.println(st + " " + l + " " + mid );
			value[st][l] = value[l][st] = value[st][mid] + value[mid][l];
			vis[l] = true;
			if (l == en) {
				return;
			} else {
				dfs(st, l, en, vis);
			}
		}
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		value = new long[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			hs.put(i, new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = hs.get(a);
			list.add(b);
			hs.put(a, list);
			
			list = hs.get(b);
			list.add(a);
			hs.put(b, list);
			
			value[a][b] = value[b][a] = v;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || value[i][j] != 0) continue;
				boolean[] vis = new boolean[n+1];
				dfs(i,i,j, vis);
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(value[start][end]+"\n");
		}
		System.out.println(sb);
		
	}
}
