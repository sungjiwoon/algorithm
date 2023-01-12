package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 문제 명 : 영역 구하기
 * 난이도 : 실버 1
 * 후기 : BFS 이용인데,, 좌표를 배열로 넣는 것에서 애를 먹었다. 
 * 문제
	눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
	예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.
	
	<그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.
	
	M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다. 
	둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 
	모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.
	
	출력
	첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.
	
	예제 입력 1 
	5 7 3
	0 2 4 4
	1 1 2 5
	4 0 6 2
	
	예제 출력 1 
	3
	1 7 13
 */
public class B_2583 {
	private static int M, N, K;
	private static int[][] map;
	private static Queue<Pair> qu;
	private static boolean[][] visited;
	private static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N  = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int[] m : map) {
			Arrays.fill(m, 1);
		}
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int i = y1; i < y2; i++) { //굳이 배열과 그림판이 똑같을 필요는 없다. 값은 똑같다. 
				for (int j = x1; j < x2; j++) {
					//System.out.println("->" + k + " (" + i + "," +j+ ")");
					map[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		qu = new LinkedList<>();
		ArrayList<Integer> areas = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || visited[i][j]) continue;
				qu.offer(new Pair(i, j));
				int count = 0;
				while (!qu.isEmpty()) {
					Pair p = qu.poll();
					for (int k = 0; k < 4; k++) {
						int xx = p.X + dx[k];
						int yy = p.Y + dy[k];
						if (xx >= M || xx < 0 || yy >= N || yy < 0) continue;
						if (map[xx][yy] == 1 && !visited[xx][yy]) {
							qu.offer(new Pair(xx, yy));
							visited[xx][yy] = true;
							count++;
						}
					}
				}
				if (count == 0) count++;
				areas.add(count);
			}
			
		}
		Collections.sort(areas);
		System.out.println(areas.size());
		for (int a : areas) {
			System.out.print(a + " ");
		}
		
		
	}
}
