package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 250201 미로만들기, 최단경로 BFS, 골드4
public class B_2665 {
    int[][] map;
    int n;
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    final int INF = 1000;

    void solve() {
        int[][] changeMap = new int[n][n]; // 검정 -> 흰색으로 바꾼 횟수 기록 (dp)

        for (int i = 0; i < n; i++) {
            Arrays.fill(changeMap[i], INF);
        }

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{0, 0});
        changeMap[0][0] = 0;

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] == 1 && changeMap[x][y] < changeMap[nx][ny]) {
                    qu.add(new int[]{nx, ny});
                    changeMap[nx][ny] = changeMap[x][y];
                }

                if (map[nx][ny] == 0 && changeMap[x][y]+1 < changeMap[nx][ny]) {
                    qu.add(new int[]{nx, ny});
                    changeMap[nx][ny] = changeMap[x][y]+1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(changeMap[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println(changeMap[n-1][n-1]);

    }
    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }

            solve();
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_2665 b = new B_2665();
        b.init();

    }
}
