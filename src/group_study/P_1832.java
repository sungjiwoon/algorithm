package group_study;

/*
문제 : 231006
난이도 : 레벨 2 (체감 : 골드 3 ㅜㅜ)
알고리즘 : 다이나믹 프로그래밍 3차원
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1832
보행자 천국

시간복잡도 n * m = 500 * 500 = O(2500)

 */
public class P_1832 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {

        int[][][] dp = new int[501][501][2]; //거리 담는 배열.

        //dp[i][j][0] 왼쪽에서 오는 방향 Left -> Right -> j-1에서 오는 방향
        //dp[i][j][1] 위쪽에서 오는 방향 Up -> Down -> i-1 에서 오는 방향

        for (int j = 0; j < n; j++) {
            if (cityMap[0][j] == 1) break;
            dp[0][j][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) break;
            dp[i][0][1] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                /* j-1 구간 => (left->right) : [i][j][0] */
                if (cityMap[i][j-1] == 0) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];
                } else if (cityMap[i][j-1] == 2) {
                    dp[i][j][0] = dp[i][j-1][0];
                } else if (cityMap[i][j-1] == 1) {
                    dp[i][j][0] = 0;
                }

                /* i-1 구간 => (up->down) : [i][j][1] */
                if (cityMap[i-1][j] == 0) {
                    dp[i][j][1] = dp[i-1][j][0] + dp[i-1][j][1];
                } else if (cityMap[i-1][j] == 2) {
                    dp[i][j][1] = dp[i-1][j][1];
                } else if (cityMap[i-1][j] == 1) {
                    dp[i][j][1] = 0;
                }

                dp[i][j][0] %= MOD;
                dp[i][j][1] %= MOD;

            }
        }

        // for (int i= 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print("("+ dp[i][j][0] + ", " + dp[i][j][1] + ") ");
        //     }
        //     System.out.println();
        // }

        int answer = dp[m-1][n-1][0] + dp[m-1][n-1][1];
        return answer % MOD;
    }
}
