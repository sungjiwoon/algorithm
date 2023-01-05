package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 골드 4!! 전에 풀었던 불 문제와 유사함. 
 * 
 * 문제
	상근이는 빈 공간과 벽으로 이루어진 건물에 갇혀있다. 건물의 일부에는 불이 났고, 
	상근이는 출구를 향해 뛰고 있다.
	
	매 초마다, 불은 동서남북 방향으로 인접한 빈 공간으로 퍼져나간다. 
	벽에는 불이 붙지 않는다. 상근이는 동서남북 인접한 칸으로 이동할 수 있으며, 1초가 걸린다. 
	상근이는 벽을 통과할 수 없고, 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동할 수 없다. 
	상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
	빌딩의 지도가 주어졌을 때, 얼마나 빨리 빌딩을 탈출할 수 있는지 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 테스트 케이스의 개수가 주어진다. 테스트 케이스는 최대 100개이다.
	각 테스트 케이스의 첫째 줄에는 빌딩 지도의 너비와 높이 w와 h가 주어진다. (1 ≤ w,h ≤ 1000)
	
	다음 h개 줄에는 w개의 문자, 빌딩의 지도가 주어진다.
	
	'.': 빈 공간
	'#': 벽
	'@': 상근이의 시작 위치
	'*': 불
	각 지도에 @의 개수는 하나이다.
	
	출력
	각 테스트 케이스마다 빌딩을 탈출하는데 가장 빠른 시간을 출력한다. 
	빌딩을 탈출할 수 없는 경우에는 "IMPOSSIBLE"을 출력한다.
 */
class Pair4{
	int X, Y, count;

	public Pair4(int x, int y, int count) {
		super();
		X = x;
		Y = y;
		this.count = count;
	}
	
}
public class B_5427 {
	static Queue<Pair4> sang, fire;
	static char[][] borad;
	static int w, h, T;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public void work() throws NumberFormatException, IOException {
		
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
