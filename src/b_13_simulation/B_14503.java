package b_13_simulation;

import java.io.*;
import java.util.*;

/** 240223 백준 14503 로봇청소기 골5 구현 */

public class B_14503 {
	static int n, m;
	static int r, c, d;
	static int[][] map;
	static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static final int EMPTY = 0, WALL = 1, CLEAN = 2;

	class Pair {
		int r, c;
		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	private static int solve() {
		int res = 0;

		Queue<Pair> qu = new LinkedList<>();

		return res;
	}

	public static void main(String[] args) {
		input();
		System.out.println(solve());
	}

	private static void input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			n = tmp[0];
			m = tmp[1];

			tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			r = tmp[0];
			c = tmp[1];
			d = tmp[2];

			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

		} catch (Exception e) {}

	}
}
