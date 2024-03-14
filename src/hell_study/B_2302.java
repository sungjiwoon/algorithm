package hell_study;

import java.io.*;
import java.util.*;
/** 240314 극장좌석 실버1 DP */
public class B_2302 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 41; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int st = 1;
        int res = 1;
        int range = 0;
        for (int l : list) {
            range = l - st;
            res *= dp[range];
            st = l + 1;
        }
        res *= dp[((n+1) - st)];
        System.out.println(res);
    }
}
