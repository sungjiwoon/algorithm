import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {	
	static int n,m, cnt;
	static HashMap<Integer, ArrayList<Integer>> hs = new HashMap<>();
	static int[][] value;
	private static void dfs(int st, int mid, int en) {
		//st -> 시작점 
		//en -> 끝나는 점.
		//cnt -> 거리
		
		ArrayList<Integer> list = hs.get(mid);
		for (int l:list) {
			if (st == l) continue;
			value[st][l] = value[st][mid] + value[mid][l];
			if (l == en) {
				cnt = value[st][en];
				return;
			} else {
				dfs(st, l, en);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		value = new int[n+1][n+1];
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
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			cnt = 0;
			dfs(start,start,end);
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
		
	}
}
