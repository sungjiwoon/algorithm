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
	static int[][] dis;
//	static int[][] disF;
	static boolean[][] visitedF = new boolean[1001][1001];
	static boolean[][] visitedJ = new boolean[1001][1001];
	static Queue<Pair2> quJ;
	static Queue<Pair2> quF;
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		borad = new char[R][C];
//		disJ = new int[R][C];
//		disF = new int[R][C];
		dis = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {				
				borad[i][j] = s.charAt(j);
			}
		}
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int[] d : dis) {
			Arrays.fill(d, -1);
		}
//		for (int[] d : disJ) {
//			Arrays.fill(d, -1);
//		}
//		
		quJ = new LinkedList<>();
		quF = new LinkedList<>();
		boolean isPossible = false; //탈출 성공 여부!
		int count = 0; 
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (borad[i][j] == 'F') {
					quF.offer(new Pair2(i, j, 0));
//					disF[i][j] = 1;
					dis[i][j] = 0;
				}
				if (borad[i][j] == 'J') {
					quJ.offer(new Pair2(i, j, 0));
//					disJ[i][j] = 1;
					dis[i][j] = 0;
				}
			}
		}

//		while (!quF.isEmpty() || isPossible) {
//			Pair2 p = quF.poll();
//			
//			for (int k = 0; k < 4; k++) {
//				int dx_x = p.X + dx[k];
//				int dy_y = p.Y + dy[k];
//				
//				if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) continue;
//				if (borad[dx_x][dy_y] == '#' || borad[dx_x][dy_y] == 'J' || dis[dx_x][dy_y] > -1) continue; //벽이거나 불 붙인 곳이면 pass 
//				
//				//borad[dx_x][dy_y] = 'F';
//				dis[dx_x][dy_y] = dis[p.X][p.Y] + 1;
//				quF.offer(new Pair2(dx_x, dy_y, p.D+1));	
//
//				System.out.println("quF  " + dx_x + " " + dy_y + " " + k);
//			}
//		}
//		while (!quJ.isEmpty()) {
//			Pair2 p = quJ.poll();
//			for (int k = 0; k < 4; k++) {
//				int dx_x = p.X + dx[k];
//				int dy_y = p.Y + dy[k];
//				
//				if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) {
//					isPossible = true; //탈출 성공했음!
//					count = p.D+1;
//					break;
//				}
//				if (borad[dx_x][dy_y] == '#' || borad[dx_x][dy_y] == 'F' || dis[dx_x][dy_y] < p.D+1 ) continue; 
//				//벽이거나,불이거나, 지훈이가방문했으면 J
//				
//				//borad[dx_x][dy_y] = 'J';
//				quJ.offer(new Pair2(dx_x, dy_y, p.D+1));
//				System.out.println("quJ  " + dx_x + " " + dy_y + " " + k);
//				
//			}			
//				
//			if (isPossible) break;
//		}
		
		while (!quF.isEmpty() || isPossible) {
			Pair2 p = quF.poll();
			Pair2 p2 = quJ.poll();
			
			for (int k = 0; k < 4; k++) {
				int dx_x = p.X + dx[k];
				int dy_y = p.Y + dy[k];
				
				if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) continue;
				if (borad[dx_x][dy_y] == '#' || borad[dx_x][dy_y] == 'J' || dis[dx_x][dy_y] > -1) continue; //벽이거나 불 붙인 곳이면 pass 
				
				if (dx_x < 0 || dx_x >= R || dy_y < 0 || dy_y >= C) {
					isPossible = true; //탈출 성공했음!
					count = p.D+1;
					break;
				}
				dis[dx_x][dy_y] = dis[p.X][p.Y] + 1;
				quF.offer(new Pair2(dx_x, dy_y, p.D+1));
				
				if (borad[dx_x][dy_y] == '#' || borad[dx_x][dy_y] == 'F' || dis[dx_x][dy_y] < p.D+1 ) continue;
				quJ.offer(new Pair2(dx_x, dy_y, p.D+1));
				//borad[dx_x][dy_y] = 'F';
					

				System.out.println("quF  " + dx_x + " " + dy_y + " " + k);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(dis[i][j] + " ");
			}
			System.out.println();
		}
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
