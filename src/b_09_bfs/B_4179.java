package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 골드 4
 * 지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!

	미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 
	그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.
	지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다)  이동한다. 
	불은 각 지점에서 네 방향으로 확산된다.
	지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다. 
	지훈이와 불은 벽이 있는 공간은 통과하지 못한다.
	
	해결 방법
	
	시작점이 2개인 (불, 지훈이 위치) 경우에는 따로따로 BFS 처리를 해준다.
	그리고 구해진 dis 배열을 비교하여 결과를 출력한다.
	
	 -> java로 푸니 계속적인 메모리 초과 발생 !!!
	 -> 한번의 반복문 안에서 계쏙적으로 확인하는 방법 선택. 
 */
class Pair2 {
	int X;
	int Y;
	int D;
	public Pair2(int x, int y, int d) {
		super();
		X = x;
		Y = y;
		D = d;
	}	
}
public class B_4179 {
	static int R, C;
	static char[][] borad;
	static Queue<Pair2> quJ;
	static Queue<Pair2> quF;
	
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		borad = new char[R][C];

		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {				
				borad[i][j] = s.charAt(j);
			}
		}
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		quJ = new LinkedList<>();
		quF = new LinkedList<>();
		boolean isPossible = false; //탈출 성공 여부!
		int count = 0; 
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (borad[i][j] == 'F') {
					quF.offer(new Pair2(i, j, 0));
				}
				if (borad[i][j] == 'J') {
					quJ.offer(new Pair2(i, j, 0));
				}
			}
		}
		
		while (!quJ.isEmpty()) {		
			int size = quF.size();
			for (int i = 0; i < size; i++) {
				Pair2 p = quF.poll();
				for (int j = 0; j < 4; j++) {
					int dx_x = p.X + dx[j];
					int dy_y = p.Y + dy[j];
					
					if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) continue;
					if (borad[dx_x][dy_y] == '#' || borad[dx_x][dy_y] == 'F') continue; 
					//벽이거나 불 붙인 곳이면 pass 
					
					borad[dx_x][dy_y] = 'F';
					quF.offer(new Pair2(dx_x, dy_y, p.D+1));
					//System.out.println("quF  " + dx_x + " " + dy_y );
				}
			}
			
			size = quJ.size();
			for (int i = 0; i < size; i++) {
				Pair2 p = quJ.poll();
				for (int k = 0; k < 4; k++) {
					int dx_x = p.X + dx[k];
					int dy_y = p.Y + dy[k];
					
					if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) {
						isPossible = true; //탈출 성공했음!
						count = p.D+1;
						break;
					}
					if (borad[dx_x][dy_y] == '#' || borad[dx_x][dy_y] == 'F' || borad[dx_x][dy_y]=='J') continue; 
					//벽이거나,불이거나, 지훈이가방문했으면 J
					
					borad[dx_x][dy_y] = 'J';
					quJ.offer(new Pair2(dx_x, dy_y, p.D+1));
					//System.out.println("->quJ  " + dx_x + " " + dy_y);
				}		
			}
			
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(borad[i][j] + " ");
//				}
//				System.out.println();
//			}
			if (isPossible) break;
			
			
		}
		
		if (isPossible) System.out.println(count);
		else System.out.println("IMPOSSIBLE");
		
		
	}
}
