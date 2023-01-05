import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair4{
	int X, Y, count;

	public Pair4(int x, int y, int count) {
		super();
		X = x;
		Y = y;
		this.count = count;
	}
	
}
public class Main {
	
	static Queue<Pair4> sang, fire;
	static char[][] borad;
	static int w, h, T;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		//기본 세팅 변수 넣기.
		
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			sang = new LinkedList<>();
			fire = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			borad = new char[h][w];

			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					borad[i][j] = s.charAt(j);
					if (borad[i][j] == '@') sang.offer(new Pair4(i, j, 0));
					else if (borad[i][j] == '*') fire.offer(new Pair4(i, j, 0));
				}
			}
			
			boolean isOk = false;
			int res = 0;
			while (!sang.isEmpty()) {				
				int size = fire.size();
				for (int i = 0; i < size; i++) {
					Pair4 p = fire.poll();
					for (int k = 0; k < 4; k++) {
						int xx = p.X + dx[k];
						int yy = p.Y + dy[k];
						if (xx >= h || xx < 0 || yy >= w || yy < 0) continue;
						if (borad[xx][yy] != '*' && borad[xx][yy] != '#' && borad[xx][yy] != '@') {
							borad[xx][yy] = '*';
							fire.offer(new Pair4(xx, yy, p.count+1));
						}
					}
				}
				size = sang.size();
				for (int i = 0; i < size; i++) {
					Pair4 p = sang.poll();
					for (int k = 0; k < 4; k++) {
						int xx = p.X + dx[k];
						int yy = p.Y + dy[k];
						if (xx >= h || xx < 0 || yy >= w || yy < 0) {
							isOk = true;
							res = p.count+1;
							break;
						}
						if (borad[xx][yy] != '#' && borad[xx][yy] != '@' && borad[xx][yy] != '*') {
							borad[xx][yy] = '@';
							sang.offer(new Pair4(xx, yy, p.count+1));
						}
					}
					if (isOk) break;
				}
				
//				for (int i = 0; i < h; i++) {
//					for (int j = 0; j < w; j++) {
//						System.out.print(borad[i][j]);
//					}
//					System.out.println();
//				}
				if (isOk) break;	
			}
			if (isOk) sb.append(res + "\n");
			else sb.append("IMPOSSIBLE\n");
			
		}
		System.out.print(sb);
	}
}
