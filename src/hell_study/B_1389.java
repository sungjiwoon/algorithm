package hell_study;

import java.io.*;
import java.util.*;

/** 240313 백준 1389 케빈 베이컨의 6단계 법칙 그래프, 플로이드 */

public class B_1389 {
    static int n;
    static int[][] friend;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer to = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(to.nextToken());
        int m = Integer.parseInt(to.nextToken());

        friend = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(friend[i], 1000);
        }

        for (int i = 1; i <= m; i++) {
            to = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(to.nextToken());
            int b = Integer.parseInt(to.nextToken());
            friend[a][b] = friend[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= n; i++) {
                    if (i == j) continue;
                    friend[i][j] = Math.min(friend[i][j], friend[i][k] + friend[k][j]);
                }
            }
        }


        int min = 10000;
        int minIdx = 0;
        for (int i = 1; i <= n; i++) {
            int sum = Arrays.stream(friend[i]).sum();
            if (sum < min) {
                min = sum;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }

}
