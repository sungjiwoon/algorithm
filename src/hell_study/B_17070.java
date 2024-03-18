package hell_study;

import java.io.*;
import java.util.*;

/** 240318 백준 파이프 옮기기 1 골드 5 DP */

public class B_17070 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i< n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] hor = new int[n][n]; // dp[i][j] = (i, j)에 파이프 끝이 올 수 있는 개수 (가로)
        int[][] ver = new int[n][n]; // 세로
        int[][] side = new int[n][n];
        hor[0][1] = 1;

        // 가로는 미리 1로 채워넣는다.
        for (int i = 2; i < n; i++) {
            if (map[0][i] == 1) break;
            hor[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 2; j < n; j++) {
                // 가로
                hor[i][j] += hor[i][j-1] + side[i][j-1];

                // 세로
                ver[i][j] += ver[i-1][j] + side[i-1][j];

                // 대각선
                if (map[i-1][j] == 0 && map[i][j-1] == 0) {
                    side[i][j] += hor[i-1][j-1] + ver[i-1][j-1] + side[i-1][j-1];
                }

                // 만약 현재 자리가 벽이라면? 갯수 0으로 초기화
                if (map[i][j] == 1) {
                    hor[i][j] = ver[i][j] = side[i][j] = 0;
                }

            }
        }

        int res = hor[n-1][n-1] + ver[n-1][n-1] + side[n-1][n-1];
        System.out.println(res);

    }
}
