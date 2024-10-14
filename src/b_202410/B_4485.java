package b_202410;

import java.io.*;
import java.util.*;
/** 241015 다익스트라 */
public class B_4485 {
    int n;
    int[][] map;
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    public int solve() {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[2] - o2[2]
        );
        // o[0] : 정점 x, o[1] : 정점 y, o[2] : 값 (도둑루피)

        pq.add(new int[]{0, 0, map[0][0]});

        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] q = pq.poll();
            int x = q[0], y = q[1], v = q[2];

            if (x == n-1 && y == n-1) {
                res = v;
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (!vis[nx][ny]) {
                    pq.add(new int[]{nx, ny, v + map[nx][ny]});
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        B_4485 b = new B_4485();
        b.init();
    }

    public void init() throws Exception {
        int cnt = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        while (n != 0) {
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }
            int value = solve();
            System.out.println(String.format("Problem %d: %d", cnt++, value));
            n = Integer.parseInt(br.readLine());
        }

    }
}
