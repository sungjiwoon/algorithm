package hell_study;

import java.io.*;
import java.util.*;

/** 240325 백준 7570 줄세우기 그리디 */
public class B_7570 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // n - 가장 긴 연속적인 수열
        // 배열의 가장 긴 순열을 찾으려면, 자기보다 낮은 수에서 + 1을 해주면된다.
        int[] dp = new int[n+1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int k = arr[i];
            dp[k] = dp[k - 1] + 1;
            max = Math.max(max, dp[k]);
        }

        System.out.println((n - max));

    }
}
