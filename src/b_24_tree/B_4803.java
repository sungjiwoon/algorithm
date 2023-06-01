package b_24_tree;

import java.io.*;
import java.util.*;

/*
 * Ʈ�� ��� 4 1��, 256MB
 * �׷����� ������ �������� �̷���� �ִ�. �� ���� ���̿� ��ΰ� �ִٸ�, �� ������ ����Ǿ� �ִٰ� �Ѵ�. 
 * ���� ��Ҵ� ��� ������ ���� ����Ǿ� �ִ� ������ �κ������̴�. �׷����� �ϳ� �Ǵ� �� �̻��� ���� ��ҷ� �̷���� �ִ�.

	Ʈ���� ����Ŭ�� ���� ���� ����̴�. Ʈ������ ���� ������ �ִ�. ���� ���, Ʈ���� ������ n��, ������ n-1�� �ִ�. 
	��, ������ �� ������ ���ؼ� ��ΰ� �����ϴ�.
	
	�׷����� �־����� ��, Ʈ���� ������ ���� ���α׷��� �ۼ��Ͻÿ�.
 */
public class B_4803 {
	static int cnt = 0;
	private static void is_tree(int n, HashMap<Integer, ArrayList<Integer>> hs) {
		
		/*
		 * Ʈ���� ���� : 
		 * ����Ŭ X ���� n�� ���� n-1��?? 
		 */
		
		boolean[] vis = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			if (!vis[i]) {
				ArrayList<Integer> list = hs.get(i);
				if (list.isEmpty()) {
					cnt++;
					vis[i] = true;
				} else {
					if (dfs(0,i, vis, hs)) cnt++;
				}
			}
		}
		
	}
	private static boolean dfs(int before, int key, boolean[] vis, HashMap<Integer, ArrayList<Integer>> hs) {
		
		ArrayList<Integer> list = hs.get(key);
		if (vis[key]) return false;
		vis[key] = true;
		for(int l : list) {
			if (before == l) continue;
			//System.out.println("key: " + key + ", l:" + l);
			boolean ok = dfs(key, l, vis, hs);
			if (!ok) return false;
			
		}
		return true;
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int tc = 1;
		while (n != 0 && m != 0) {
		
			HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> list = new ArrayList<>();
				hs.put(i, list);
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				ArrayList<Integer> list = hs.get(a);
				list.add(b);
				hs.put(a, list);
				
				list = hs.get(b);
				list.add(a);
				hs.put(b, list);
			}
			
			cnt = 0; //Ʈ���� ���� . 
			is_tree(n, hs);
			if (cnt == 1) sb.append("Case " + tc + ": There is one tree.\n");
			else if (cnt == 0) sb.append("Case " + tc + ": No trees.\n");
			else {
				sb.append("Case " + tc + ": A forest of " + cnt + " trees.\n");
			}
			tc++;
			
			//�ʱ�ȭ.
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
		}
		System.out.println(sb);
		
	}
}
