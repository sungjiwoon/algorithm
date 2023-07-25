package b_23_graph;
import java.io.*;
import java.util.*;

//거짓말 (골4)

public class B_1043_unionfind {
	static int n,m;
	static int[] parent;
	static ArrayList<Integer>[] graph, party;
	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	private static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if (a > b) parent[a] = b;
		else parent[b] = a;
	}
	private static void reset() {

		parent = new int[n+1];
		for (int i = 1; i <= n; i++) parent[i] = i;

		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Integer>();

		party = new ArrayList[m];

	}
	public void work() throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		reset(); //graph, party, parent reset

		st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken()); //진실 아는 사람의 수.

		LinkedList<Integer> lie = new LinkedList<>();
		while (k-- > 0) {
			int kk = Integer.parseInt(st.nextToken());
			parent[kk] = 0;
			lie.offer(kk);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			party[i] = new ArrayList<>();
			int member = Integer.parseInt(st.nextToken()); //파티에 오는 수.

			int p = Integer.parseInt(st.nextToken());
			party[i].add(p);

			while (member-- > 1) { //파티 맴버들
				int q = Integer.parseInt(st.nextToken());
				party[i].add(q);
				graph[p].add(q); //p를 기준으로 파티에 온 모든 인원들이 그래프처럼 이어짐.
				graph[q].add(p);
			}

		}

		boolean[] vis = new boolean[n+1]; //무한반복을 피하기위한 방법.
		while (!lie.isEmpty()) {
			int p = lie.poll(); //거짓말인걸 아는 사람.
			for (int q : graph[p]) {
				union(p,q);
				if (!vis[q]) lie.offer(q);
			}
			vis[p] = true;
		}

		int ans = 0;
		for (int i = 0; i < m; i++) {
			boolean ok = true;
			for (int p : party[i]) {
				if (parent[p] == 0) {
					ok = false;
					break;
				}
			}
			if (ok) ans++;
		}
		System.out.println(Arrays.toString(parent));
		System.out.println(ans);
	}
}










