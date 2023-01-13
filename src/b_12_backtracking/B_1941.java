package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_1941 {
	static char[][] map = new char[5][5];
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static boolean[][] vis = new boolean[5][5];
	static int count = 0;
	private static void func(int x, int y, String s) {
		
		if (s.length()==7) {
			//System.out.println(s);
			int n= 0;
			for (int i = 0; i < 7; i++) {
				if (s.charAt(i)=='S') n++;
			}
			if (n>=4) count++;
			//System.out.println(count);
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			if (xx >= 5 || xx < 0 || yy >= 5 || yy < 0) continue;
					
			if (!vis[xx][yy]) {
				vis[xx][yy] = true;
				s+=map[xx][yy];
				func(xx, yy, s);
				vis[xx][yy] = false;
				//System.out.println(s+":( " + xx+" "+yy+" )");				
			}					
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) 
				map[i][j] = s.charAt(j);
		}
		for (int i = 0; i < 5; i++) 
			for (int j = 0; j < 5; j++)
				func(i,j,"");
		System.out.print(count);
	}
}
