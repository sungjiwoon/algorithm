package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2961 {
    int n;
    int[][] foods;
    int res = Integer.MAX_VALUE;

    private void dfs(int depth, int val1, int val2, int cnt) {
        if (depth == n) {
//            System.out.println(val1 + " " + val2);
            if (cnt == 0) return;
            res = Math.min(Math.abs(val1 - val2), res);
            return;
        }

        for (int i = depth; i < n; i++) {
            // 음식 i번째를 추가했나, 혹은 추가 하지 않았나.
            dfs(i+1, val1 * foods[i][0], val2 + foods[i][1], cnt+1);
            dfs(i+1, val1, val2, cnt);
        }
    }

    private void solve() {
        init();
        dfs(0, 1, 0, 0);
        System.out.println(res);
    }



    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            foods = new int[n][2];
            for (int i = 0; i < n; i++) {
                foods[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }


        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_2961 b = new B_2961();
        b.solve();
    }

}
