package hell_study;

import java.io.*;
import java.util.*;

/** 240307 백준 구간 합 구하기 DP 실버 1*/

public class B_11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 구간 합 구하기
        int[][] sum = new int[n][n];
        sum[0][0] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    sum[i][j] = sum[i][j-1] + map[i][j];
                } else if (j == 0 && i > 0) {
                    sum[i][j] = sum[i-1][j] + map[i][j];
                } else if (i > 0 && j > 0) {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] + map[i][j] - sum[i-1][j-1];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = xy[0]-1, y1 = xy[1]-1, x2 = xy[2]-1, y2 = xy[3]-1;
            int res = 0;

            if (x1 > 0 && y1 > 0) res = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            else if (x1 == 0 && y1 > 0) res = sum[x2][y2] - sum[x2][y1-1];
            else if (x1 > 0 && y1 == 0) res = sum[x2][y2] - sum[x1-1][y2];
            else res = sum[x2][y2];

            sb.append(res+"\n");
        }
        System.out.println(sb);
    }
}
