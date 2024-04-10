import java.io.*;
import java.util.*;

public class Main {
    final int N = 16;
    final int M = 31;

    boolean[][] basecamp = new boolean[N][N];
    boolean[][] notMoveCamp = new boolean[N][N];

    Pair[] peopleWant = new Pair[M]; //원하는 편의점.
    Pair[] peopleLoc = new Pair[M]; // 현재 위치.
    boolean[] peopleArrive = new boolean[M];

    int n, m;
    int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    int t = 1;

    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Pair bfsBasecamp(int wx, int wy) {

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(wx, wy));
        boolean[][] vis = new boolean[N][N];
        vis[wx][wy] = true;

        int[][] minD = new int[N][N];
        int minX = 0, minY = 0;
        minD[0][0] = Integer.MAX_VALUE;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k], ny = p.y + dy[k];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) continue;
                if (vis[nx][ny] || notMoveCamp[nx][ny]) continue;

                qu.add(new Pair(nx, ny));
                minD[nx][ny] = minD[p.x][p.y] + 1;
                vis[nx][ny] = true;

                if (basecamp[nx][ny]) {
                    if (minD[nx][ny] < minD[minX][minY]) {
                        minX = nx;
                        minY = ny;
                    } else if (minD[nx][ny] == minD[minX][minY]) {
                        if (nx == minX && ny < minY) {
                            minX = nx;
                            minY = ny;
                        } else if (nx < minX) {
                            minX = nx;
                            minY = ny;
                        }
                    }
                }
            }
        }
        return new Pair(minX, minY);
    }

    public void selectBacecamp() {
        Pair wp = peopleWant[t];

        Pair bp = bfsBasecamp(wp.x, wp.y);
        basecamp[bp.x][bp.y] = false;
        notMoveCamp[bp.x][bp.y] = true;
        peopleLoc[t] = new Pair(bp.x, bp.y);

    }

    public Pair bfs(int wx, int wy, int lx, int ly) {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(wx, wy));
        boolean[][] vis = new boolean[N][N];
        vis[wx][wy] = true;

        int[][] minD = new int[N][N];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(minD[i], Integer.MAX_VALUE);
        }

        int minX = 0, minY = 0;
        minD[lx][ly] = Integer.MAX_VALUE;
        minD[wx][wy] = 0;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k], ny = p.y + dy[k];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) continue;
                if (notMoveCamp[nx][ny]) continue;
                if (vis[nx][ny] || minD[p.x][p.y] + 1 > minD[nx][ny]) continue;

                if (nx == lx && ny == ly) {
                    if (minD[p.x][p.y] + 1 < minD[nx][ny]) {
                        minX = p.x;
                        minY = p.y;
                    } else if (minD[p.x][p.y] + 1 == minD[nx][ny]) {
                        if (p.x == minX && p.y < minY) {
                            minX = p.x;
                            minY = p.y;
                        } else if (p.x < minX) {
                            minX = p.x;
                            minY = p.y;
                        }
                    }
                }

                minD[nx][ny] = minD[p.x][p.y]+1;
                qu.add(new Pair(nx, ny));
                vis[nx][ny] = true;
            }
        }

        return new Pair(minX, minY);
    }

    public void move() {
        List<Pair> notMoveList = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            if (i >= t) break; // 격자에 없다면.
            if (peopleArrive[i]) continue; //이미 편의점에 도착했다면.

            Pair loc = peopleLoc[i];
            Pair wp = peopleWant[i];
            Pair np = bfs(wp.x, wp.y, loc.x, loc.y);

            if (np.x == wp.x && np.y == wp.y) {
                // 편의점 도착 .
                notMoveList.add(np);
                peopleArrive[i] = true;
            }
            peopleLoc[i] = new Pair(np.x, np.y);

        }

        for (Pair p : notMoveList) {
            notMoveCamp[p.x][p.y] = true;
        }
    }

    public boolean finish() {
        for (int i = 1; i <= m; i++) {
            if (!peopleArrive[i]) return false;
        }
        return true;
    }


    public void solve() {
        while (true) {
            // 1 - 격자 안에 있는 사람들 본인이 가고싶은 편의점 방향 향해 1칸 전진.
            // 최단거리로 움직임.
            // 2. 편의점 도착하면, 편의점에서 멈추고, 그 칸은 못 움직인다.
            move();
            if (finish()) break;

            // 3. 베이스 캠프로 이동. t번째 사람이 이동함.
            // 가장 가까운 베이스 캠프로 이동한다.
            if (t <= m) selectBacecamp();

            t++;
        }

        System.out.println(t);
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        m.init();
        m.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int idx = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    basecamp[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            peopleWant[i] = new Pair(x, y);
        }

    }
}