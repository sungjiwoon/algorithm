package b_15_dp;

import java.util.*;
import java.io.*;

/**
 * dp[시간][이동횟수]
 * 0. 이동을 안했다면 (w == 0) ?
 * if (현재의 위치 = 열매의 떨어지는 위치) 이전 시간의 이동횟수 같은 값 + 1
 * else 이전 시간 이동횟수의 값 그대로
 *
 * 1. 이동 했을 때?
 * 이동한 횟수 짝수, 홀수 인지에 따라 현재 위치 구함. 짝수 = 1번 나무, 홀수 = 2번 나무
 * if (현재의 위치 = 열매의 떨어지는 위치)
 *  * if (가만히 있는 경우) dp[t - 1][w] + 1
 *  * else 움직인 경우 dp[t - 1][w - 1]
 *  둘 중 큰값이 dp[t][w] 에 저장
 *
 * else if (현재의 위치 != 열매의 떨어지는 위치)
 *  *  if (가만히 있는 경우) dp[t - 1][w]
 *  *  else 움직인 경우 dp[t - 1][w - 1]
 *  *  둘 중 큰값이 dp[t][w] 에 저장
 *
 */
public class B_2240 {
    int T, W;
    int[] info;

    int res;
    private int solve() {
        int[][] dp = new int[T + 1][W + 1];

        for (int i = 1; i <= T; i++) {
            int tree = info[i];
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    // 움직임이 없는 경우 => w = 0
                    if (tree == 1) { // 원래 위치가 1이니까
                        dp[i][w] = dp[i-1][w] + 1;
                    } else {
                        dp[i][w] = dp[i-1][w];
                    }
                } else if (w % 2 == 0) {
                    //  이동 횟수가 짝수다 => tree 1과 동일
                    if (tree == 1) {
                        // 이동했을 경우(자두 안받음) 와 이동하지 않았을 경우 (자두 받음) 중 최댓값.
                        dp[i][w] = Math.max(dp[i - 1][w - 1], dp[i - 1][w] + 1);
                    } else {
                        dp[i][w] = Math.max(dp[i - 1][w - 1] + 1, dp[i - 1][w]);
                    }

                } else {
                    if (tree == 2) {
                        // 이동했을 경우(자두 안받음) 와 이동하지 않았을 경우 (자두 받음) 중 최댓값.
                        dp[i][w] = Math.max(dp[i - 1][w - 1], dp[i - 1][w] + 1);
                    } else {
                        dp[i][w] = Math.max(dp[i - 1][w - 1] + 1, dp[i - 1][w]);
                    }
                }
            }
        }

        int res = 0;
        for (int w = 0; w <= W; w++) {
            res = Math.max(res, dp[T][w]);
        }

        return res;


    }

    public static void main(String[] args) {
        B_2240 m = new B_2240();
//        Main m = new Main();
        m.input();

        System.out.println(m.solve());

    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            T = tmp[0];
            W = tmp[1];
            info = new int[T + 1];
            for (int i = 1; i <= T; i++) {
                info[i] = Integer.parseInt(br.readLine());
            }
        } catch (Exception e) {}

    }
}
