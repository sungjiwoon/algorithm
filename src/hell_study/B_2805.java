package hell_study;

import java.io.*;
import java.util.*;

/** 240228 백준 나무자르기 실버 2 이분탐색 */
public class B_2805 {
    int n, m;
    long[] trees;
    Map<Long, Boolean> vis = new HashMap<>();
    long res = 0;

    private void solve(long st, long en) {
        long x = (en + st) / 2;

        if (vis.containsKey(x)) return;
        vis.put(x, true);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i] < x) continue;
            ans += trees[i] - x;
        }

        if (ans < m) {
            solve(st, x);
        } else {
            res = Math.max(res, x);
            solve(x + 1, en);
        }
    }

    public static void main(String[] args) {
        B_2805 b = new B_2805();
//        Main b = new Main();
        b.input();
        b.solve(0, 1000000000);
        System.out.println(b.res);

    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            m = tmp[1];

            trees = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();


        } catch (Exception e) {}
    }
}
