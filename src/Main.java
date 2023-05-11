import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	static int n, m, max_length=0;
	static char[][] map;
	static Map<String, Integer> hs = new HashMap<>();
	
	private static void dfs(int i, int j, String s) {
		
		if (hs.get(s) != null) { 
			hs.put(s, hs.get(s)+1);
		}
		if (s.length() == max_length) { /* dfs 종료 지점  -> 신이 좋아하는 문자열 중 가장 긴 문자열 길이를 중심으로 !*/
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
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new char[n+1][m+1];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		String[] valueSet = new String[K]; //순서대로 입력하기 위함. 
		
		for (int i = 0; i < K; i++) {
			String s = br.readLine();
			hs.put(s, 0);
			valueSet[i] = s; //일반 배열에 값을 넣어주어 나중에 출력할 때 위함.
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
