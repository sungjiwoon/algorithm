import java.util.*;
import java.io.*;


public class Main
{
	static int n, S,T;
	static ArrayList<Integer>[] graph;
	static HashMap<Integer, Integer> common, course;
	static ArrayList<Integer> res;
	static boolean[] vis;
	static int[][] pre;

	private static void track_pre(int nxt, int v, int start) {

		while (pre[nxt][v] != start) {
			course.put(nxt, course.get(nxt)+1);
			course.put(v, course.get(v)+1);
			int tmp = v;
			v = pre[nxt][v];
			nxt = tmp;
			System.out.println("pre: " + nxt);
		}

	}
	private static void dfs(int pre_v, int v, int target, int start) {

		for (int nxt : graph[v]) {
			if (vis[nxt]) continue;
			pre[nxt][v] = pre_v;
			System.out.println("pre["+nxt+"]["+v+"] = " + pre_v);

			if (nxt == target || course.get(nxt) >= 1) {
				track_pre(nxt, v, start);
				return;
			}
			vis[v] = true;
			dfs(v, nxt, target, start);

		}
	}
	private static void go_to_work() {
		//출근길 모든 길 조사.

		vis = new boolean[n+1];
		course = new HashMap<>();
		for (int i = 1; i <= n; i++) course.put(i, 0);
		pre = new int[n+1][n+1];
		common = new HashMap<>();

		for (int nxt : graph[S]) {
			if (course.get(nxt) >= 1) continue;
			//pre[nxt][S] = S;
			dfs(S, nxt, T, S);
		}

		for (int i = 1; i <= n; i++) {
			if (course.get(i) >= 1) common.put(i, 1);
		}
		System.out.println();

	}
	private static void go_to_home() {

		vis = new boolean[n+1];
		course = new HashMap<>();
		for (int i = 1; i <= n; i++) course.put(i, 0);
		pre = new int[n+1][n+1];

		for (int nxt : graph[T]) {
			if (course.get(nxt) >= 1) continue;
			pre[nxt][T] = T;
			dfs(T, nxt, S,T);
		}

		for (int i = 1; i <= n; i++) {
			if (course.get(i) >= 1 && common.containsKey(i) && i != S && i != T) res.add(i);
		}

	}
	public static void main(String args[]) throws IOException
	{

		input();
		go_to_work();
		go_to_home();
		for (int r: res) {
			System.out.println(r);
		}

	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		res = new ArrayList<>();
	}
}