package study_alone;

import java.io.*;
import java.util.*;

public class B_1965 {
    static int[] arr;
    static int n;
    // lower_bound
    static void solve() {
        /*
        배열의 마지막 요소보다 새로운 수가 크다면, 배열에 넣는다.
        그렇지 않으면, 그 수가 들어갈 자리에 넣는다.
         */
        class Pair implements Comparable<Pair> {
            int idx, v;
            Pair(int idx, int v) {
                this.idx = idx;
                this.v = v;
            }

            @Override
            public int compareTo(Pair p) {
                if (p.v == this.v) return p.idx - this.idx;
                return this.v - p.v;
            }
        }

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair ip = new Pair(i, arr[i]);
            list.add(ip);
        }

        Collections.sort(list);

        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }


    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 2중 포문
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
