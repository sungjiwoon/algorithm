package b_23_graph;
import java.io.*;
import java.util.*;
/*
 * ȯ�� 
 * ��� ������ ������ �����ϴ� ���� �Ұ����ϴ�. �׷��� �߾ӿ� Ȥ�� �������� ���� �׷����� ǥ���Ͽ���. 
 */
public class B_5214 {
	static final int INF = 100000+1;
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adj = new ArrayList[n+1];
		for (int i = 1; i<= n; i++) adj[i] = new ArrayList<>();
			
		//����ö ���� ��.
		ArrayList<Integer>[] subway = new ArrayList[m+1];
		
		Queue<Integer> qu = new LinkedList<>();
		
		HashMap<Integer, Integer> end = new HashMap<>(); //�������� ��� ���� ����.
		int[] route = new int[m+1];
		Arrays.fill(route, INF);
		
		for (int j = 1; j <= m; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			subway[j] = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				int v = Integer.parseInt(st.nextToken());
				subway[j].add(v);
				adj[v].add(j);
				
				if (v == 1) {
					qu.add(j);
					route[j] = 1;
				}
				if (v == n) end.put(j, 1);
			}
		}

		boolean[] vis_st = new boolean[n+1]; //������ �湮. 
		vis_st[1] = true;
		boolean[] vis_sub = new boolean[m+1]; //������ ������ ��� ���� �湮 ǥ��
		int ans = INF;
		
		while (!qu.isEmpty()) {
			int num = qu.poll(); //������ ��ȣ�� �����. 
			vis_sub[num] = true;
			System.out.println(num);
			
			if (end.containsKey(num)) {
				ans = Math.min(route[num]+1, ans);
				break;
			}
			
			for (int nxt : subway[num]) {
				if (vis_st[nxt]) continue;
				vis_st[nxt] =true;
				
				for (int diff : adj[nxt]) {
					if (vis_sub[diff]) continue;
					route[diff] = Math.min(route[diff], route[num]+1);
					System.out.println(nxt + "��: ("+diff + ") " + route[diff]);
					qu.add(diff);
					vis_sub[diff] = true;
				}
			}
			
		}
		if (ans == INF) ans = -1;
		if (n == 1) ans = 1;
		System.out.println(ans);
		
		
	}
}











