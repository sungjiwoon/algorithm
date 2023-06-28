package b_23_graph;
import java.io.*;
import java.util.*;

/*
 * ������ 
 * ��� 4
 * ��Ƽ ���� �ο����� �׷����� ���� ����Ǯ�� 
 */

public class B_1043 {
	public void work() throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		boolean[] lie = new boolean[n+1];
		Queue<Integer> qu = new LinkedList<>();
		while (k-- > 0) {
			int p = Integer.parseInt(st.nextToken());
			lie[p] = true;
			qu.add(p);
		}
		
		ArrayList<Integer>[] party = new ArrayList[m];
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) party[i] = new ArrayList<>();
		
		//ó�� ��Ƽ������ �׷����� ��ΰ� �̾����� �ؾ���. 
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()); //������. 
			party[i].add(a);
			
			while (size-- > 1) {
				int v = Integer.parseInt(st.nextToken());
				party[i].add(v);
				graph[a].add(v);
				graph[v].add(a);
			}
		}
		
		
		//lies �ɹ��� �������� ������ �ƴ� ��� ����. 
		
		boolean[] vis = new boolean[n+1];
		while (!qu.isEmpty()) {
			int q = qu.poll();
			
			for (int nxt : graph[q]) {
				if (vis[nxt]) continue;
				lie[nxt] = true;
				qu.add(nxt);
				vis[nxt] = true;
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			boolean ok = true;
			
			for (int nxt : party[i]) {
				if (lie[nxt]) {
					ok = false;
					break;
				}
			}
			
			if (ok) cnt++;
				
		}
		
		System.out.println(cnt);
		
		
	}
}










