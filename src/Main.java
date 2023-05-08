import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
			}
		}		
		
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		char[][] res = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				res[i][j] = '.';
				if (s.charAt(j)=='x') {
					int r = 0;
					for (int k = 0; k < 8; k++) {
						int xx = i + dx[k];
						int yy = j + dy[k];
						if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
						if (map[xx][yy] == '*') r++;
					}
					res[i][j] = Character.forDigit(r, 10);
				}
			}
		}
		
		for (int i =0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
		
		
	}
	
}
