import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class W {
	int x, y;
	W(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {	
	static int n, m, chi, hoi;
	static HashMap<Integer, W> ch, home;
	static int min = Integer.MAX_VALUE;
	
	private static void func(int[] arr, int depth, int st, boolean[] vis) {
		if (depth == m) {
			//System.out.println(Arrays.toString(arr));
			min = Math.min(cnt_d(arr), min);
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
	private static int cnt_d(int[] arr) {
		//arr엔 치킨집이 담겨있음. 
		
		/*
		 * 각 집마다 치킨집의 거리를 계산하여 오름차순으로 넣는다! 
		 */
		PriorityQueue<int[]> qu = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		//arr에 담겨있는 배열. 
		for (int i = 0; i < m; i++) {
			W c = ch.get(arr[i]);
			
			for (int j = 1; j < hoi; j++) {
				W h = home.get(j);
				
				int d = Math.abs(c.x- h.x) + Math.abs(c.y-h.y);
				int[] tmp = {j, d};
				qu.add(tmp);
			}
		}
		
		boolean[] vis = new boolean[hoi];
		int vis_i = 0;
		int ans = 0;
		while (vis_i < hoi-1) {
			int[] q = qu.poll();
			if (vis[q[0]]) continue;
			vis[q[0]] = true;
			vis_i++;
			ans += q[1];
		}
		
		return ans;
		
		
	}

	public static void main(String[] args) throws Exception {	
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
		
		int[] arr = new int[m];
		boolean[] vis = new boolean[chi];
		func(arr, 0,1,vis);
		
		System.out.println(min);
	
	}
}
