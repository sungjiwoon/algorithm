package b_13_simulation;

import java.io.*;
import java.util.*;
/*
 * 치킨 배달 (골드 5) 
 * 미리 구해놓ㅇ는게 정말 중요하다. 
 */
class W {
	int x, y;
	W(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class B_15686 {
	static int n, m, chi, hoi;
	static HashMap<Integer, W> ch, home;
	static int min = Integer.MAX_VALUE;
	static int[][] d;
	private static void func(int[] arr, int depth, int st, boolean[] vis) {
		if (depth == m) {
			//System.out.println(Arrays.toString(arr));
			int sum = 0;
			int[] min_d = new int[hoi];
			Arrays.fill(min_d, Integer.MAX_VALUE);
			for (int i = 0; i < m; i++) {
				for (int j = 1; j < hoi; j++) {
					min_d[j] = Math.min(min_d[j], d[j][arr[i]]);
				}
			}
			
			for (int j = 1; j < hoi; j++) {
				sum += min_d[j];
			}
			min = Math.min(sum, min);
			return;
		}
		
		for (int i = st; i < chi; i++) {
			if (!vis[i]) {
				vis[i] = true;
				arr[depth] = i;
				func(arr, depth+1, st+1, vis);
				vis[i] = false;
			}
		}
	}
	private static void cnt_d() {
		//arr엔 치킨집이 담겨있음. 
		
		for (int i = 1; i < chi; i++) {
			W c = ch.get(i);
			for (int j = 1; j < hoi; j++) {
				W h = home.get(j);
				d[j][i] = Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
			}
		}
		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		ch = new HashMap<>(); //치킨집 위치 담는 곳. 
		chi = 1; //치킨집
		
		home = new HashMap<>();
		hoi = 1; //집의 갯수. 
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 2) {
					ch.put(chi++, new W(i,j));
				} else if (v == 1) {
					home.put(hoi++, new W(i,j));
				}
			}
		}
		d = new int[hoi][chi];
		cnt_d();
		
		int[] arr = new int[m];
		boolean[] vis = new boolean[chi];
		func(arr, 0,1,vis);
		
		System.out.println(min);
		
	}
}







