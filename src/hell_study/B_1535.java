package hell_study;

import java.io.*;
import java.util.*;
/** 240306 백준 안녕 DP, 배낭 알고리즘 실버2 */
public class B_1535 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //체력
        int[] J = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //기쁨

        int[] dp = new int[100];
        // 1 ~ 99 체력 단계 별로 기쁨의 최댓값을 구한다.
        // dp[i] - 체력 i일 때 기쁨의 최댓값

        for (int i = 0; i < n; i++) {
            for (int j = 99; j >= L[i]; j--) {
                dp[j] = Math.max(dp[j - L[i]] + J[i], dp[j-1]); //전 체력 그대로 가져오기.
            }
        }

        System.out.println(dp[99]);


    }
}
