package b_20_hash;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
public class B_20166 {
	static int n, m, max_length=0;
	static char[][] map;
	static Map<String, Integer> hs = new HashMap<>();
	
	private void dfs(int i, int j, String s) {
		
		if (hs.get(s) != null) {
			hs.put(s, hs.get(s)+1);
		}
		if (s.length() == max_length) {
			return;
		}
		
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		for (int k = 0; k < 8; k++) {
			int xx = i + dx[k];
			int yy = j + dy[k];
			
			/* 예외처리 */
			if (xx < 0) xx = n-1;
			if (xx >= n) xx = 0;
			if (yy < 0) yy = m-1;
			if (yy >= m) yy = 0;
			
			dfs(xx, yy, s+String.valueOf(map[xx][yy]));
		}
	}
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		String[] valueSet = new String[m];
		
		for (int i = 0; i < K; i++) {
			String s = br.readLine();
			hs.put(s, 0);
			valueSet[i] = s;
			max_length = Math.max(max_length, s.length());
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i,j,String.valueOf(map[i][j]));
			}
		}
		
		for (int i = 0; i < K; i++) {
			System.out.println(hs.get(valueSet[i]));
		}
	}
}









