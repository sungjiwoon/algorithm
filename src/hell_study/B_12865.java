package hell_study;

import java.io.*;
import java.util.*;

/** 240220 백준 평범한 배낭 골드 5 DP */

public class B_12865 {
    static int n, k;
    static int[][] things;
    private static int solve() {
        int res = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

            }
        }


        return res;
    }
    public static void main(String[] args)  {
        input();
        System.out.println(solve());
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            k = tmp[1];
            things = new int[n][2];
            for (int i = 0; i < n; i++) {
                things[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }
}
