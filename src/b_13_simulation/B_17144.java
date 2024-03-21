package b_13_simulation;

import java.io.*;
import java.util.*;
/** 240321 백준 미세먼지의 확산 골4 구현 */
public class B_17144 {
    int r, c, t;
    int[][] map;
    int cleanerX1, cleanerX2;
    int[] dx = {0,-1,0,1}, dy = {1,0,-1,0}; //반시계가 기본

    private void spray() {

        int[][] newMap = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (j == 0 && (i == cleanerX1 || i == cleanerX2)) continue;
                int sprayAmount = (int) Math.floor((double) map[i][j] / 5.0);
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if (ny == 0 && (nx == cleanerX1 || nx == cleanerX2)) continue;
                    cnt++;
                    newMap[nx][ny] += sprayAmount;
                }

                newMap[i][j] += (map[i][j] - sprayAmount * cnt);
            }
        }

        map = newMap.clone();
    }

    private void operate() {
        // 반시계 순환
        int[][] newMap = new int[r][c];
        int bx = cleanerX1, by = 0;
        int nx = cleanerX1, ny = 1;
        int dir = 0; // 반시계 시작

        while (nx != cleanerX1 || ny != 0) {
            newMap[nx][ny] = map[bx][by];
            bx = nx;
            by = ny;
            nx = bx + dx[dir];
            ny = by + dy[dir];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                dir = (dir + 1) % 4;
                nx = bx + dx[dir];
                ny = by + dy[dir];
            }
        }

        bx = cleanerX2;
        by = 0;
        nx = cleanerX2;
        ny = 1;
        dir = 0; // 시계 시작
        while (nx != cleanerX2 || ny != 0) {
            newMap[nx][ny] = map[bx][by];
            bx = nx;
            by = ny;
            nx = bx + dx[dir];
            ny = by + dy[dir];
            if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                dir = (dir + 4 - 1) % 4;
                nx = bx + dx[dir];
                ny = by + dy[dir];
            }
        }

        // 가운데 부분 채워줘여함.
        for (int i = 1; i < cleanerX1; i++) {
            for (int j = 1; j < c-1; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        for (int i = cleanerX2 + 1; i < r-1; i++) {
            for (int j = 1; j < c-1; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        map = newMap.clone();

    }

    private void print() {
        System.out.println("= print =");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    private int solve() {
        for (int i = 0; i < t; i++) {
            // 미세먼지의 확산
            spray();

            // 공기청정기의 작동
            operate();
        }

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res += map[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        B_17144 b = new B_17144();
        b.input();
        System.out.println(b.solve());

    }
    private void input () {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            map = new int[r][c];
            cleanerX1 = -1;
            cleanerX2 = -1;
            for (int i = 0; i < r; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                if (map[i][0] == -1 && cleanerX1 == -1) {
                    cleanerX1 = i;
                    cleanerX2 = i + 1;
                }
            }
        } catch(Exception e) {}
    }
}
