package hell_study;

import java.io.*;

/** 240219 백준 달팽이 실버 3 구현 */

public class B_1913 {
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int ansX = 0, ansY = 0;

        int[][] map = new int[n][n];
        int loc = 1;
        int x = n/2, y = n/2;
        int dir = UP;
        int step = 1;

        map[x][y] = loc++;
        while (loc < n * n) {

            for (int i = 1; i <= step; i++) {
                x += dx[dir];
                y += dy[dir];
                map[x][y] = loc++;
                if (loc > n * n) break;
            }

            switch (dir) {
                case UP :
                    dir = RIGHT;
                    break;
                case RIGHT :
                    dir = DOWN;
                    step++;
                    break;
                case DOWN :
                    dir = LEFT;
                    break;
                case LEFT :
                    dir = UP;
                    step++;
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j] + " ");

                if (map[i][j] == target) {
                    ansX = i + 1;
                    ansY = j + 1;
                }
            }
            sb.append("\n");
        }

        sb.append(String.format("%d %d", ansX, ansY));
        System.out.println(sb);

    }
}
