import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {	
	
	static int[] res;
	static HashMap<Integer, Integer> hm;
	static int n;
	private static void dfs(int member, int value) {
		//member : ÄªÂù ¹ÞÀº »ç¶÷ //value : ÄªÂù ¼öÄ¡ . 
		res[member] += value;
		if (member == n) return;
		int next = hm.get(member);
		dfs(next, value);
		
		
	}
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		res = new int[n+1];
		hm = new HashMap<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			int member = Integer.parseInt(st.nextToken());
			hm.put(member, i);
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int member = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			dfs(member, value);
		}
		
		for (int i = 1; i <= n; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
