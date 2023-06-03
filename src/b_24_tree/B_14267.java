package b_24_tree;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * ������ ���� ~
 * ȸ�� ��ȭ 1 ��4
 * dp �� dfs�� ������ �ż��ߴ�. 
 */
public class B_14267 {
	static long[] res;
	static HashMap<Integer, ArrayList<Integer>> hm;
	static int n;
	private static void dfs(int member) {
		//member : Ī�� ���� ��� //value : Ī�� ��ġ . 
		
		//if (member == n) return;
		
		ArrayList<Integer> list = hm.get(member);
		for (int next : list) {
			
			res[next] += res[member];
			System.out.println(next + " + " + res[member] + " = " + res[next]);
			dfs(next);
		}		
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		res = new long[n+1];
		hm = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			hm.put(i, list);
		}
		
		//arrayList : ���� ���ϵ��� ����. 
		st = new StringTokenizer(br.readLine(), " ");
		int boss = 0;
		for (int i = 1; i <= n; i++) {
			int member = Integer.parseInt(st.nextToken());
			if (member == -1) {
				boss = i;
				continue;
			}
			ArrayList<Integer> list = hm.get(member);
			list.add(i);
			hm.put(member, list); //i�� ���� ��簡 member��. 
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int member = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			res[member] = value;
			
		}
		dfs(boss);
		for (int i = 1; i <= n; i++) {
			System.out.print(res[i] + " ");
		}
		
		
	}
}
