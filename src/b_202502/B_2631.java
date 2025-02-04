package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 250204 줄 세우기 DP, LIS(최장 긴 수열)
public class B_2631 {

    int n;
    int[] nums;

    private void solve() {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
            System.out.println(i +" :" + dp[i] + " ");
        }
        System.out.println((n-max)); // 가장 긴 수열의 애들이 키순으로 가장 길게 섰음
        // 그외 나머지만 옮겨주면 됨
    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }
            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2631 b = new B_2631();
        b.init();
    }
}
