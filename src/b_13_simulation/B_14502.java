package b_13_simulation;

import java.io.*;
import java.util.*;

/*
 * 연구소 (골드4) 2초/512MB
 * 풀이 : dfs + bfs 방법 이용.
 * 벽을 세울수 있는 배열의 조합을 모두 구해서, 하나씩 대입. -> dfs
 * 바이러스 퍼뜨리는 것은 bfs 
 * 
 * 문제
	인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
	
	연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 
	
	일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
	
	예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.
	
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
	
	2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.
	
	2 1 0 0 1 1 0
	1 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 1 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	바이러스가 퍼진 뒤의 모습은 아래와 같아진다.
	
	2 1 0 0 1 1 2
	1 0 1 0 1 2 2
	0 1 1 0 1 2 2
	0 1 0 0 0 1 2
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
	
	연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)
	
	둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.
	
	빈 칸의 개수는 3개 이상이다.
	
	출력
	첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.
	
	예제 입력 1 
	7 7
	2 0 0 0 1 1 0
	0 0 1 0 1 2 0
	0 1 1 0 1 0 0
	0 1 0 0 0 0 0
	0 0 0 0 0 1 1
	0 1 0 0 0 0 0
	0 1 0 0 0 0 0
	예제 출력 1 
	27
 * 
 */
public class B_14502 {
	static int n, m;
	static int[][] map;
	static int[] nums, arr;
	static boolean[] vis;
	static int best = Integer.MIN_VALUE;
	
	private static void dfs(int depth, int st) {
		if (depth == 3) { 
			for (int i = 0; i < 3; i++) {
				int k = arr[i];
				int ci = k/m;
				int cj = k%m;
				if (map[ci][cj] != 0) return;
			}
			
			//bfs 실행 하여 max 값 찾기. 
			best = Math.max(bfs(), best);
			return;
		}
		
		for (int i = st; i < n*m; i++) {
			if (!vis[i]) {
				vis[i] = true;
				arr[depth] = nums[i];
				dfs(depth+1,i);
				vis[i] = false;
			}
		}
	}
	private static int bfs() {
		int[][] map_copy = new int[n][m];
		Queue<Pair> qu = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map_copy[i][j] = map[i][j];
				
				if (map_copy[i][j] == 2) qu.offer(new Pair(i,j));
			}
		}
		
		for (int i = 0; i < 3; i++) {
			int k = arr[i];
			int ci = k/m;
			int cj = k%m;
			map_copy[ci][cj] = 1;
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			for (int k = 0; k < 4; k++) {
				int xx = p.X+dx[k];
				int yy = p.Y+dy[k];
				if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
				if (map_copy[xx][yy] == 1) continue;
				if (map_copy[xx][yy] == 0) {
					map_copy[xx][yy] = 2;
					qu.offer(new Pair(xx,yy));
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map_copy[i][j] == 0) sum++;
			}
		}
		
		return sum;
		
		
	}
	public void work() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		nums = new int[n*m];
		for (int i = 0; i < n*m; i++) {
			nums[i] = i;
		}
		arr = new int[3];
		vis = new boolean[n*m];
		
		
		dfs(0,0);
		System.out.println(best);
		
	}
}
