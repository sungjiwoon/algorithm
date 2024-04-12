package study_alone;

import java.io.*;
import java.util.*;

/** 240412 코드트리 삼성 자율주행 전기차 BFS 구현 골드2 */
public class CT_240412 {
    final int N = 22;
    final int INF = Integer.MAX_VALUE;
    int n, m, c;

    int[][] map = new int[N][N];
    int[][] pStart = new int[N][N], pEnd = new int[N][N];
    int[][] step = new int[N][N];
    Pair[] pEndList = new Pair[N*N];

    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    Pair car;

    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean canGo(int x, int y) {
        return (0 < x && x <= n && 0 < y && y <= n)
                && (map[x][y] == 0);
    }

    public void print() {
        System.out.println("이동거리 프린트");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (step[i][j] == INF) System.out.print(-1 + " ");
                else System.out.print(step[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void bfs() {
        step = new int[N][N];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(step[i], INF);
        }

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(car.x, car.y));
        step[car.x][car.y] = 0;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k], ny = p.y + dy[k];
                if (canGo(nx, ny) && step[nx][ny] > step[p.x][p.y] + 1) {
                    step[nx][ny] = step[p.x][p.y] + 1;
                    qu.add(new Pair(nx, ny));
                }
            }
        }
    }

    public int pickup() {
        int minIdx = 0;
        int minX = 0, minY = 0;
        int minD = INF;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (pStart[i][j] > 0 && minD > step[i][j]) {
                    minD = step[i][j];
                    minIdx = pStart[i][j];
                    minX = i;
                    minY = j;
                }
            }
        }

        c -= minD;
        car = new Pair(minX, minY);
        pStart[minX][minY] = 0;
        if (c < 0) return -1;
        return minIdx;
    }


    public void solve() {
        for (int i = 1; i <= m; i++) {

            bfs();

            // 가장 가까운 승객 태움.
            int idx = pickup();
            if (c <= -1) {
                c = -1;
                break;
            }

            // 승객을 데려다줌.
            bfs();

            Pair end = pEndList[idx];
            int ex = end.x, ey = end.y;
            car = new Pair(ex, ey);

            int consume = step[ex][ey];
            c -= consume;
            if (c <= -1) {
                c = -1;
                break;
            }

            c += consume * 2;
        }
        System.out.println(c);
    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        CT_240412 m = new CT_240412();
        m.init();
        m.solve();

    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        car = new Pair(x, y);

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            pStart[x1][y1] = i;
            pEnd[x2][y2] = i;
            pEndList[i] = new Pair(x2, y2);
        }

    }
}
