package hell_study;

import java.io.*;
import java.util.*;

public class B_11055 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];
        int max = 0;
        dp[0] = input[0];

        for (int i = 1; i < n; i++) {
            dp[i] = input[i];
            for (int j = i - 1; j >= 0; j--) {
                if (input[i] > input[j]) {
                    dp[i] = Math.max(dp[j] + input[i], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
