package b_202410;

import java.util.*;
import java.io.*;

/**
 * 벽 부수고 이동하기 (골3)
 * BFS 응용
 */

public class B_14442 {

    int[][] map = new int[1001][1001];
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    int n, m, k;

    public void solve() {
        int[][][] dist = new int[1001][1001][2];
        // dist[x][y][0] - 벽을 하나도 부수지 않고, (x,y)까지 오는데 비용
        // dist[x][y][1] - 벽을 하나만 부수고, (x,y) 까지 오는데 비용. (x,y)가 벽이라서 부수는 비용도 포함

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dist[i][j][0] = dist[i][j][1] = -1;
            }
        }

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{1, 1, 0});
        dist[1][1][0] = dist[1][1][1] = 1;

        int res = -1;

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], broken = q[2];

            if (x == n && y == m) {
                res = dist[x][y][broken];
                break;
            }

            int nextDist = dist[x][y][broken] + 1;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx <= 0 || nx > n || ny <= 0 || ny > m) continue;

                if (map[nx][ny] == 0 && dist[nx][ny][broken] == -1) {
                    qu.add(new int[]{nx, ny, broken});
                    dist[nx][ny][broken] = nextDist;
                }

                // nx, ny가 벽인 경우 > 부심 (단 broken = 0)
                if (map[nx][ny] == 1 && broken == 0 && dist[nx][ny][broken] == -1) {
                    qu.add(new int[]{nx, ny, 1});
                    dist[nx][ny][1] = nextDist;
                }

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
//        k = arr[2];

        for (int i = 1; i <= n; i++) {
            String st = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(st.charAt(j-1)));
            }
        }

    }
}
