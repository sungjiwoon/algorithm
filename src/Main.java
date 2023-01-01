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



class Pair {
	int X, Y;
	public Pair(int x, int y) {
		super();
		X = x;
		Y = y;
	}
}

public class Main {
	static int R, C;
	static char[][] borad;
	static int[][] disJ;
	static int[][] disF;
	static Queue<Pair> quJ;
	static Queue<Pair> quF;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		borad = new char[R][C];
		disJ = new int[R][C];
		disF = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {				
				borad[i][j] = s.charAt(j);
			}
		}
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int[] d : disF) {
			Arrays.fill(d, -1);
		}
		for (int[] d : disJ) {
			Arrays.fill(d, -1);
		}
		
		quJ = new LinkedList<>();
		quF = new LinkedList<>();
		boolean isPossible = false; //탈출 성공 여부!
		int count = 0; 
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (borad[i][j] == 'F') {
					quF.offer(new Pair(i, j));
					disF[i][j] = 1;
				}
				if (borad[i][j] == 'J') {
					quJ.offer(new Pair(i, j));
					disJ[i][j] = 1;
				}
			}
		}
		
		while (!quF.isEmpty()) {
			Pair p = quF.poll();
			for (int k = 0; k < 4; k++) {
				int dx_x = p.X + dx[k];
				int dy_y = p.Y + dy[k];
				
				if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) continue;
				
				if (borad[dx_x][dy_y] != '#' && disF[dx_x][dy_y] < 0 ) {
					disF[dx_x][dy_y] = disF[p.X][p.Y]+1;
					quF.offer(new Pair(dx_x, dy_y));
				}			
				
			}
		}
		while (!quJ.isEmpty()) {
			Pair p = quJ.poll();
			for (int k = 0; k < 4; k++) {
				int dx_x = p.X + dx[k];
				int dy_y = p.Y + dy[k];
				
				if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) {
					isPossible = true; //탈출 성공했음!
					count = disJ[p.X][p.Y]+1;
					break;
				}
				if (borad[dx_x][dy_y] != '#' && disJ[dx_x][dy_y] > -1 ) continue;
				
				//disF가 방문한 흔적이 있다거나, 혹은 방문이 늦어지면 continue; 해준다. 
				if (disF[dx_x][dy_y] != -1 && disF[dx_x][dy_y] <=  disJ[p.X][p.Y]+1) continue;
				
				disJ[dx_x][dy_y] = disJ[p.X][p.Y]+1;
				quJ.offer(new Pair(dx_x, dy_y));
			}			
				
			if (isPossible) break;
		}
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(disF[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(disJ[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		if (isPossible) System.out.println(count);
		else System.out.println("IMPOSSIBLE");
		
		
	}
}
