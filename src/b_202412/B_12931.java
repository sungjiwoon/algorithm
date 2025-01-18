package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 240119 그리디 두배더하기 */
public class B_12931 {

    int n;
    int[] B;

    void solve() {
        init();

        int[] dp = new int[1001]; // dp[i] = i번째 값이 1이 되기 위한 최소 호
        int[] cnt2 = new int[1001]; // cnt2[i] = i번째 값이 1이 되기 위해 최소한의 값에서, 2로 나눈 방법의 횟수
        int[] cnt1 = new int[1001]; // cnt1[i] = i번째 값이 1이 되기 위해 최소한의 값에서, -1한 횟수
        // 1. 배열의 있는 한개의 값 1 증가 ( B->A : B[i]-1)
        // 2. 배열의 있는 모든 값 2배 시킨다 (B->A : B[all]/2)

        // dp[i] = dp[i/2] + 1
        // dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
        // 1000까지 값 구하기
        dp[1] = 0;
        for (int i = 2; i <= 1000; i++) {
            if (i % 2 == 0 && dp[i/2] <= dp[i-1]) {
                cnt2[i] = cnt2[i/2] + 1;
                dp[i] = dp[i/2]+1;
                cnt1[i] = cnt1[i/2];
            } else {
                dp[i] = dp[i-1]+1;
                cnt2[i] = cnt2[i-1];
                cnt1[i] = cnt1[i-1]+1;
            }

//            System.out.println("dp["+i+"]="+dp[i] +", cnt2["+i+"]="+cnt2[i] + "cnt1["+i+"]="+cnt1[i]);
        }

        // 2로 나누는건 전역 방법이므로, 가장 많이 2로 나누는 횟수가 더해진다.
        // 1로 빼는건 각각의 값이므로 더해준다.

        int sum = 0;
        int max2 = 0;
        int cnt0 = 0;
        for (int i = 0; i < n; i++) {
            if (B[i] == 0) cnt0++;
            max2 = Math.max(cnt2[B[i]], max2);
            sum += cnt1[B[i]];
        }

        sum = sum + max2 + n - cnt0;
        System.out.println(sum);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_12931 b = new B_12931();
        b.solve();
    }
}
