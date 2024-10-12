package b_202410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 벽 부수고 이동하기 3 (골1)
 */
public class B_16933 {
    int[][] map = new int[1001][1001];
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    int n, m, k;

    public void solve() {
        int[][][] dist = new int[1001][1001][12];
        // dist[x][y][k] - 벽을 k번 부수고, (x,y) 까지 오는데 비용. (x,y)가 벽이라서 부수는 비용도 포함

        // 낮인 경우 > 벽 부수기 가능
        // 밤인 경우 > 벽 부수기 불가능, 칸에 머물고, 낮에 벽 부수기 가능

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{1, 1, 0, 0});
        dist[1][1][0] = 1;

        int res = -1;
        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], broken = q[2];
            int time = q[3]; // 0 - 낮, 1 - 밤
            //System.out.println(String.format("dist[%d][%d][%d] = %d", x, y, broken, dist[x][y][broken]));
            if (x == n && y == m) {
                res = dist[x][y][broken];
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                int nextTime = time ^ 1;
                int nextDist = dist[x][y][broken] + 1;
                int wb = broken;
                if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;

                // 만약 nx, ny가 벽이라면, 넣어보자. // k번까지는 부술 수 있음.
                if (map[nx][ny] == 1) {
                    //System.out.println(String.format("map[%d][%d] = 1, broken = %d", nx, ny, wb));
                    if (time == 1) { // 밤
                        nextTime = time;
                        nextDist++;
                    }
                    wb++;
                }

                if (wb > k || (dist[nx][ny][wb] > 0 && dist[nx][ny][wb] < nextDist)) continue;
                dist[nx][ny][wb] = nextDist;
                qu.add(new int[]{nx, ny, wb, nextTime});
            }
        }

        System.out.println(res);
    }


    public static void main(String[] args) throws Exception {
        B_16933 b = new B_16933();
        b.input();
        b.solve();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        k = arr[2];

        for (int i = 1; i <= n; i++) {
            String st = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j-1)));
            }
        }

    }
}
