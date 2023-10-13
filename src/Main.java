import java.io.*;
import java.util.*;

public class Main {
	int n, m;
	int[][] map;
	int[][] player;
	int[][] seq;
	int[] monster;
	int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	long score = 0;

	class Pair {
		int x, y;
		Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void init() {
		//달팽이 모양으로 인덱스 부여한 seq 배열 만들기.

		monster = new int[n*n+1];
		seq = new int[n][n];
		int dir = 2, mv = 1;
		int x = n/2, y = n/2;
		int k = 1;
		seq[x][y] = 0;

		while (k < n * n) {
			for (int j = 0; j < mv; j++) {
				x = x + dx[dir];
				y = y + dy[dir];
				if (x < 0 || y < 0 || x >= n || y>= n) break;
				monster[k] = map[x][y];
				seq[x][y] = k++;
			}
			dir = (dir - 1 + 4) % 4;
			if (dir == 0 || dir == 2) mv++;
		}
	}

	public void attack(int idx) {
		//플레이어 공격
		int attackDir = player[idx][0];
		int attackSize = player[idx][1];

		int x = n/2, y = n/2;

		for (int i = 1; i <= attackSize; i++) {
			x = x + dx[attackDir];
			y = y + dy[attackDir];
			if (x < 0 || y< 0 || x >= n || y >= n) break;
			int attacked = seq[x][y];
			if (monster[attacked] == 0) break;
			score += monster[attacked];
			System.out.println("kill: " + monster[attacked]);
			monster[attacked] = -1;
		}
	}
	public void printMap() {
		for (int i = 1; i < n*n; i++) {
			System.out.print(monster[i]+"("+i+") ");
		}
		System.out.println();
	}
	public void monsterMove() {

		int[] newMonster = new int[n*n+1];
		int idx = 1;

//		System.out.println("before:");
		//printMap();

		for (int i = 1; i < n*n; i++) {
			if (monster[i] == 0) break;
			if (monster[i] != -1) newMonster[idx++] = monster[i];
			else if (monster[i] == -1) {
				int j = i + 1;
				while (monster[j] != -1 && monster[j] != 0) {
					newMonster[idx++] = monster[j];
					j++;
				}
				i = j-1;
			}

		}

		for (int i = 0; i < n*n; i++) {
			monster[i] = newMonster[i];
		}

//		System.out.println("after:");
		printMap();

		while (idDelete()) {
			System.out.println("after2:");
			//printMap();
		}
	}
	public int[][] bomb(int st) {
		int[][] tmp = {{-1}, {0}};
		while (true) {
			int j = st;
			int v = monster[st];
			if (v == 0) break;
			while (j < n * n && monster[++j] == v);
			int size = j - st;
			int idx = 0;
			if (size >= 4) {
				tmp = new int[2][size];
				System.out.println("D:" + st + "->" + j + ",size: " + size);
				System.out.println("score: " + monster[st]);
				for (int k = j; k < j + size; k++) {
					if (k >= n * n) break;
					tmp[0][idx++] = monster[k];
					score += monster[k - size];
				}
				tmp[1][0] = j + idx - 1;
				st = j + idx;
			} else {
				break;
			}
		}

		return tmp;
	}
	public boolean idDelete() {
		boolean ok = false;
		int[] newMonster = new int[n * n + 1];
		int idx = 1;
		for (int i = 1; i < n * n - 4; i++) {
			if (monster[i] == 0) break;

			int[][] tmp = bomb(i);
			if (tmp[0][0] == -1) {
				newMonster[idx++] = monster[i];
				continue;
			}
			for (int j = 0; j < tmp[0].length; j++) {
				if (tmp[0][j] == 0) break;
				newMonster[idx++] = tmp[0][j];
			}
			i = tmp[1][0];
			ok = true;
		}

		for (int i = 0; i < n * n; i++) {
			monster[i] = newMonster[i];
		}

		return ok;
	}
//	public boolean idDelete() {
//		boolean ok = false;
//		int[] newMonster = new int[n*n+1];
//		int idx = 1;
//		for (int i = 1; i < n*n; i++) {
//			if (monster[i] == 0) break;
//
//			int j = i;
//			while (j < n*n && monster[++j] == monster[i]);
//			int size = j - i;
//			if (size >= 4) {
//				for (int k = j; k < j + size; k++) {
//					if (k >= n*n) break;
//					newMonster[idx++] = monster[k];
//				}
//				System.out.println("D:" + i + "->" + j+ ",size: " + size);
//				System.out.println("score: " + monster[i] * size);
//				score += monster[i] * size;
//				i = j + size - 1;
//				ok = true;
//
//			} else {
//				newMonster[idx++] = monster[i];
//			}
//		}
//
//		for (int i = 0; i < n*n; i++) {
//			monster[i] = newMonster[i];
//		}
//
//		return ok;
//	}

	public void makePair() {
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 1; i < n*n; i++) {
			if (monster[i] == 0) break;
			int v = monster[i];
			int j = i;
			while (j < n*n && monster[++j] == monster[i]);
			list.add(new int[]{j-i, v});
			i = j - 1;
		}

		int i = 1;
		monster = new int[n*n + 1];
		for (int[] it : list) {
			if (i < n*n) monster[i++] = it[0];
			if (i < n*n) monster[i++] = it[1];
			if (i > n*n) break;
		}

		//System.out.println("makePair():\n" + Arrays.toString(monster));
	}

	public void solve() {
		init();

		for (int i = 0; i < m; i++) {
			//1. 플레이어 공격
			attack(i);
			//2. 비어있는 공간만큼 몬스터 이동.
			//3. 이때 몬스터 4번만큼 나오면 몬스터 삭제 (반복)
			monsterMove();

			//4. 차례로 나열했을 때 같은 숫자끼리 짝을 지어줌. (갯수, 숫자의 크기)
			//5.  삭제되는 몬스터의 번호만큼 점수 ++;
			makePair();
		}
		System.out.println(score);


	}
	public static void main(String[] args) {
		// 여기에 코드를 작성해주세요.
		Main m = new Main();
		m.input();
		m.solve();

	}
	public void input() {
		try {
			BufferedReader br =
					new BufferedReader(new InputStreamReader(System.in));
			String[] sp = br.readLine().split(" ");
			n = Integer.parseInt(sp[0]);
			m = Integer.parseInt(sp[1]);

			map = new int[n][n];
			player = new int[m][2];
			for (int i = 0; i < n; i++) {
				sp = br.readLine().split(" ");
				map[i] = Arrays.stream(sp).mapToInt(Integer::parseInt).toArray();
			}

			for (int i = 0; i < m; i++) {
				sp = br.readLine().split(" ");
				player[i] = Arrays.stream(sp).mapToInt(Integer::parseInt).toArray();
			}
		} catch (Exception e) {}
	}
}