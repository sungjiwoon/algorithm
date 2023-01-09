import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	private static int M, N, K;
	private static int[][] map;
	private static Queue<Pair> qu;
	private static boolean[][] visited;
	private static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
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
			
			for (int i = M-y1-1; i >= M-y2; i--) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = 0;
				}
			}
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
