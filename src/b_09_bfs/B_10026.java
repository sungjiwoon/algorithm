package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 골드 5
 * 큐를 두개를 만들어서 각각 풀었다. 난이도는 괜찮은 편같다. 
 * 	문제
	적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
	
	크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데,
	구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
	
	예를 들어, 그림이 아래와 같은 경우에
	
	RRRBB
	GGBBB
	BBBRR
	BBRRR
	RRRRR
	적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
	
	그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
	
	둘째 줄부터 N개 줄에는 그림이 주어진다.
	
	출력
	적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
 * 
 */
public class B_10026 {
	static int N;
	static char[][] borad;
	static char[][] borad2;
	static Queue<Color> qu1, qu2;
	class Color {
		int x,y;
		char c;
		public Color(int x, int y, char c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		borad = new char[N][N];
		borad2 = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				borad[i][j] = s.charAt(j);
				borad2[i][j] = s.charAt(j);
				if (borad[i][j] == 'G') borad2[i][j] = 'R';
			}
		}
		
		qu1 = new LinkedList<>();
		qu2 = new LinkedList<>();
		boolean[][] visited1 = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int[] rgb = {0, 0, 0}; //red, green, blue
		
		int count1 = 0, count2 = 0;
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {				
				if (!visited1[i][j]) {
					qu1.offer(new Color(i, j, borad[i][j]));
					visited1[i][j] = true;
					while (!qu1.isEmpty()) {
						Color c = qu1.poll();
						for (int k = 0; k < 4; k++) {
							int xx = c.x+dx[k];
							int yy = c.y+dy[k];
							
							if (xx>=N || xx<0 || yy>=N || yy<0) continue;
							if (c.c == borad[xx][yy] && !visited1[xx][yy]) {							
								visited1[xx][yy]=true;
								qu1.offer(new Color(xx, yy, c.c));
							}
						}
					}
					count1++;
				}
				
				if (!visited2[i][j]) {
					qu2.offer(new Color(i, j, borad2[i][j]));
					visited2[i][j] = true;
					while (!qu2.isEmpty()) {
						Color c = qu2.poll();
						for (int k = 0; k < 4; k++) {
							int xx = c.x+dx[k];
							int yy = c.y+dy[k];
							
							if (xx>=N || xx<0 || yy>=N || yy<0) continue;
							
							if (c.c == borad2[xx][yy] && !visited2[xx][yy]) {							
								visited2[xx][yy]=true;
								qu2.offer(new Color(xx, yy, c.c));
							}
						}
					}
					count2++;
				}		
				
			}
		} //반복문 끝
//		int sum = rgb[0]+rgb[1]+rgb[2];
		System.out.println(count1+ " " + count2);
		
		
	}
}
