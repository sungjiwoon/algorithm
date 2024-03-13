package hell_study;

import java.io.*;
import java.util.*;

/** 240313 백준 10830 행렬 제곱 골드 4 */

public class B_10830 {
    static int n;
    static int[][] map;
    static final int MOD = 1000;
    private static int[][] solve(long x) {

        // 분할 정복
        // x가 짝수일 경우 A의 n승 = A의 n/2승의 곱
        // x가 홀수일 경우 A의 n승 = A의 (n-1)/2승의 곱 * A
        System.out.println("calculate " + x);
        if (x == 1) return map;

        int[][] res = solve(x / 2);

        if (x % 2 == 0) { //짝수
            return calculate(res, res);
        } else { //홀수
            int[][] res2 = calculate(res, map);
            return calculate(res, res2);
        }

    }

    private static int[][] calculate(int[][] arr1, int[][] arr2) {
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += (arr1[i][k] * arr2[k][j]) % MOD;
                }
                res[i][j] %= MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer to = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(to.nextToken());
        long b = Long.parseLong(to.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .map(it -> it % MOD)
                    .toArray();
        }

        System.out.println(String.format("n : %d, b : %d", n, b));

        int[][] res = solve(b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }
}
