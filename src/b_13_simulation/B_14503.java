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

	static class Pair {
		int r, c;
		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	private static boolean isRange(int nr, int nc) {
		return (nr >= 0 && nc >= 0 && nr < n && nc < m);
	}
	private static int solve() {
		Queue<Pair> qu = new LinkedList<>();
		qu.add(new Pair(r, c));
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			map[p.r][p.c] = CLEAN; // 1번 - 청소

			boolean isClean = true;
			for (int k = 0; k < 4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if (!isRange(nr, nc)) continue;
				if (map[nr][nc] == EMPTY) {
					// 3번 청소되지 않는 빈칸이 있는 경우
					isClean = false;
					break;
				}
			}

			if (isClean) {
				// 2번 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
				// 2-1 바라보는 방향 유지한채, 한칸 후진할 수 있다면 후진.
				int backD = (d + 4 - 2) % 4;
				int nr = p.r + dr[backD];
				int nc = p.c + dc[backD];
				if (isRange(nr, nc) && map[nr][nc] != WALL) {
					qu.add(new Pair(nr, nc));
					continue;
				}
				// 2-2 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 STOP
				if (isRange(nr, nc) && map[nr][nc] == WALL) {
					break; // 종료 지점
				}
			} else { // 3번 청소되지 않는 빈칸이 있는 경우
				// 3-1 반시계 회전.
				d = (d + 4 - 1) % 4;
				// 3-2 바라보는 방향으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한칸 전진한다.
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (isRange(nr, nc) && map[nr][nc] == EMPTY) {
					qu.add(new Pair(nr, nc));
				} else {
					// 원래 있던거 다시 넣음.
					qu.add(p);
				}
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == CLEAN) {
					res++;
				}
			}
		}
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
