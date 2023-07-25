import java.io.*;
import java.util.*;

public class Main {
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
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		reset(); //graph, party, parent reset

		st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken()); //진실 아는 사람의 수.
		while (k-- > 0) {
			int kk = Integer.parseInt(st.nextToken());
			parent[kk] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			party[i] = new ArrayList<>();
			int member = Integer.parseInt(st.nextToken()); //파티에 오는 수.

			while (member-- > 0) { //파티 맴버들
				party[i].add(Integer.parseInt(st.nextToken()));
			}

			for (int p : party[i]) {
				for (int q : party[i]) {
					if (p == q) continue;
					graph[p].add(q);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int p : graph[i]) {
				union(i,p);
			}
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

		System.out.println(ans);
	}

}

