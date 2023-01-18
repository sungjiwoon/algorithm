import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair {
	int X, Y;
	Pair(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
}

public class Main {
	static int n, m;
	static int[][] map1 = new int[10][10], map2 = new int[10][10];
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static ArrayList<Pair> cctv = new ArrayList<>();
	static int mn = Integer.MAX_VALUE;
	private static void upd(Pair p, int dir) {
		dir %= 4; 
		int x = p.X;
		int y = p.Y;
		while (true) {
			x += dx[dir];
			y += dy[dir];
			if (x < 0 || x >= n || y < 0 || y >= m || map2[x][y] == 6) return;
			if (map2[x][y] != 0) continue;
			map2[x][y] = 7;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map1[i][j] = Integer.parseInt(st.nextToken());
				if (map1[i][j] > 0 && map1[i][j] < 6) {
					cctv.add(new Pair(i,j));
				}
			}			
		}
		
		for (int tmp = 0; tmp < Math.pow(4, cctv.size()); tmp++) {
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < m; j++)
					map2[i][j] = map1[i][j]; 
			
			int brute = tmp;
			for (int i = 0; i < cctv.size(); i++) {
				int dir = brute % 4;
				brute /= 4;
				//4진법 구간. 4의 방향의 모든 경우의 수를 만날 수 있음. 
				
				Pair p_c = cctv.get(i);
				int x = p_c.X;
				int y = p_c.Y;
				
				int monitor = map1[x][y];				
				Pair p = new Pair(x,y);
				
				switch(monitor) {
				case 1 :
					upd(p,dir);
					break;
				case 2 :
					upd(p,dir);
					upd(p,dir+2);
					break;
				case 3 :
					upd(p,dir);
					upd(p,dir+1);
					break;
				case 4 :
					upd(p,dir);
					upd(p,dir+1);
					upd(p,dir+2);
					break;
				case 5 :
					upd(p,dir);
					upd(p,dir+1);
					upd(p,dir+2);
					upd(p,dir+3);
					break;
				}
			}
			int cnt = 0; //사각지대 갯수
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map2[i][j] == 0) cnt++;
				}
			}
			mn = Math.min(cnt, mn);
			
			
		}
		System.out.println(mn);
		
	}
}
