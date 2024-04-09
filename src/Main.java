import java.io.*;
import java.util.*;
public class Main {
	final int N = 11;
	int n, m, k;
	int[][] map = new int[N][N];
	int[][] personMap = new int[N][N];
	int exitX = 0, exitY = 0;
	int res = 0;
	int rx = 0, ry = 0, size = 0;

	int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

	public int getD(int x1, int x2, int y1, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}

	public int movePerson() {
		int[][] newPersonMap = new int[N][N];
		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (personMap[i][j] == 0) continue;
				int mD = getD(i, exitX, j, exitY);
				int minD = mD, minX = i, minY = j;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d], ny = j + dy[d];
					if (nx <= 0 || ny <= 0 || nx > n || ny > n || map[nx][ny] > 0) continue;
					int dd = getD(nx, exitX, ny, exitY);
					if (mD > dd && minD > dd) {
						minD = dd;
						minX = nx;
						minY = ny;
					}
				}
				newPersonMap[minX][minY] += personMap[i][j];
				if (minD < mD) cnt += personMap[i][j];
				if (minX == exitX && minY == exitY) {
					newPersonMap[minX][minY] = 0;
				}
			}
		}
		personMap = newPersonMap;
		return cnt;

	}

	public void findMinSquare() {
		for (int sz = 2; sz <= n; sz++) {
			for (int x1 = 1; x1 <= n - sz + 1; x1++) {
				for (int y1 = 1; y1 <= n - sz + 1; y1++) {
					int x2 = x1 + sz - 1, y2 = y1 + sz - 1;
					if (!(x1 <= exitX && x2 >= exitX && y1 <= exitY && y2 >= exitY)) continue;
					for (int p1 = x1; p1 <= x2; p1++) {
						for (int p2 = y1; p2 <= y2; p2++) {
							if (personMap[p1][p2] > 0) {
								size = sz;
								rx = x1;
								ry = y1;
								return;
							}
						}
					}
				}
			}
		}
	}

	public void rotate() {
		//출구를 포함한 가장 작은 정사각형 찾기.
		findMinSquare();

		int[][] newMap = new int[N][N];
		int[][] pNewMap = new int[N][N];
		int[][] copyMap = new int[N][N];
		int[][] pCopyMap = new int[N][N];


		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				copyMap[i][j] = map[rx + i][ry + j];
				pCopyMap[i][j] = personMap[rx + i][ry + j];
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				newMap[i][j] = copyMap[size-j-1][i];
				pNewMap[i][j] = pCopyMap[size-j-1][i];
				if (newMap[i][j] > 0) newMap[i][j]--;
			}
		}

		int cx = exitX - rx;
		int cy = exitY - ry;
		int ex = cy;
		int ey = size - cx - 1;
		int tmpX = exitX, tmpY = exitY;
		exitX = ex + rx;
		exitY = ey + ry;


		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				map[rx+i][ry+j] = newMap[i][j];
				personMap[rx+i][ry+j] = pNewMap[i][j];
			}
		}
	}

	public void print() {
		System.out.println("= Map print = ");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printP() {
		System.out.println("= person Map print = ");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(personMap[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean finish() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (personMap[i][j] > 0) return false;
			}
		}
		return true;
	}



	public void solve() {
		for (int i = 1; i <= k; i++) {
			// System.out.println("= " + i + " =");
			//1. 1초마다 모든 참가자의 1칸씩 이동
			res += movePerson();
			if (finish()) break;

			//2. 미로 회전
			rotate();
		}

		System.out.println(res);
		System.out.println(exitX + " " + exitY);
	}

	public static void main(String[] args) throws Exception {
		// 여기에 코드를 작성해주세요.
		Main m = new Main();
		m.init();
		m.solve();

	}

	public void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			personMap[x][y]++;
		}

		st = new StringTokenizer(br.readLine(), " ");
		exitX = Integer.parseInt(st.nextToken());
		exitY = Integer.parseInt(st.nextToken());


	}
}