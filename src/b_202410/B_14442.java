package b_202410;

import java.io.*;
import java.util.*;

/**
 * 241006
 * 벽 부수고 이동하기 3 (골3)
 * BFS 응용 > 시간 초과
 */

public class B_14442 {
    int[][] map = new int[1001][1001];
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    int n, m, k;

    public void solve() {
        int[][][] dist = new int[1001][1001][12];
        // dist[x][y][k] - 벽을 k번 부수고, (x,y) 까지 오는데 비용. (x,y)가 벽이라서 부수는 비용도 포함

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{1, 1, 0});
        dist[1][1][0] = 1;

        int res = -1;
        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], broken = q[2];
            //System.out.println(String.format("dist[%d][%d][%d] = %d", x, y, broken, dist[x][y][broken]));
            if (x == n && y == m) {
                res = dist[x][y][broken];
                break;
            }

            int nextDist = dist[x][y][broken] + 1;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;

                // 만약 nx, ny가 벽이라면, 넣어보자. // k번까지는 부술 수 있음.
                int wb = broken;
                if (map[nx][ny] == 1) {
                    //System.out.println(String.format("map[%d][%d] = 1, broken = %d", nx, ny, broken+1));
                    wb++;
                }

                if (wb > k || dist[nx][ny][wb] > 0) continue;
                dist[nx][ny][wb] = nextDist;
                qu.add(new int[]{nx, ny, wb});
            }
        }

        System.out.println(res);
    }


    public static void main(String[] args) throws Exception {
        B_14442 b = new B_14442();
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
