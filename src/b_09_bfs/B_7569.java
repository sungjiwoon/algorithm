package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 골드 5
 * 3차원 배열 구조를 배울 수 있던 좋은 시간!
 * 
 * 문제
	철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.	
	창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
	보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
	하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
	대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
	철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
	
	토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
	단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
	
	입력
	첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. 
	M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 
	둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 
	각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 
	이러한 N개의 줄이 H번 반복하여 주어진다.
	
	토마토가 하나 이상 있는 경우만 입력으로 주어진다.
	
	출력
	여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 * 
 */
class Pair3 {
	int x,y,z;
	public Pair3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
public class B_7569 {
	static int M, N, H;
	static int[][][] borad;
	static int[][][] dis;
	static Queue<Pair3> qu;
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());		
		borad = new int[H][N][M];
		dis = new int[H][N][M];
		qu = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0, 0, 0};
		int[] dy = {0, 1, 0, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, -1, 1};
		for (int d[][] : dis) {
			for (int d2[] : d)
				Arrays.fill(d2,  -1);
		}
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					borad[h][i][j] = Integer.parseInt(st.nextToken());				
					if (borad[h][i][j] == 1) {
						qu.offer(new Pair3(i, j, h));
						dis[h][i][j] = 0;
					}
				}
			}
		}
		while (!qu.isEmpty()) {
			Pair3 p = qu.poll();
			for (int k = 0; k < 6; k++) {
				int xx = p.x + dx[k];
				int yy = p.y + dy[k];
				int zz = p.z + dz[k];
				
				
				if (xx >= N || xx < 0 || yy >= M || yy < 0 || zz >= H || zz < 0 ) continue;
				
				if (dis[zz][xx][yy] == -1 && borad[zz][xx][yy] == 0) {
					dis[zz][xx][yy] = dis[p.z][p.x][p.y]+1;
					qu.offer(new Pair3(xx, yy,zz));
					//System.out.println("-> " + xx + " " + yy);
				}
			}
		}	
		
		int max = 0; //가장 오래된 날 뽑기 위한 값. 
		boolean isOk = true;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					max = Math.max(dis[h][i][j], max);
					if (borad[h][i][j] == 0 && dis[h][i][j] == -1) {
						isOk = false;
						break;
					}
				}
				if (!isOk) break;
			}
		}
		
		if (!isOk) System.out.println("-1");
		else System.out.println(max);	
		
		
	}
}
