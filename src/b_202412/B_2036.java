package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 240127 수열의 점수 그리디 */
public class B_2036 {
    long[] nums;
    int n;

    void solve() {
        long sum = 0;

        Arrays.sort(nums);

        boolean[] vis = new boolean[n];

        // -인 부분은 곱해서 없애기
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            if (i+1 < n && nums[i+1] <= 0) {
                System.out.print("\nA: " + nums[i] + " * " + nums[i+1] + " = " + (nums[i]*nums[i+1]));
                sum += (nums[i] * nums[i+1]);
                vis[i] = vis[i+1] = true;
            } else if (i+1 < n && nums[i] <= 0 && nums[i+1] >= 1) {
                System.out.print("\nB: " + sum + " + " + nums[i] + " = " + (sum+nums[i]));
                sum += (nums[i]);
                vis[i] = true;
                break;
            } else if (i == n-1 && nums[i] <= 0) {
                sum += nums[i];
                vis[i] = true;
            }
            System.out.println("sum : " + sum);
        }

        // 양수 부분 (nums[i] >= 1)
        for (int i = n-1; i >= 0; i--) {
            if (vis[i]) break;

            if (i-1 >= 0 && nums[i-1] > 1) {
                System.out.print("\nC: " + nums[i] +" * " + nums[i-1] + "= " + (nums[i] * nums[i-1]));
                sum += (nums[i] * nums[i-1]);

                vis[i] = vis[i-1] = true;
                i--;
            } else if (i-1 >= 0 && (vis[i-1] || nums[i-1] == 1)) {
                sum += nums[i];
                vis[i] = true;
            } else if (nums[i] == 1 || !vis[i]) {
                sum += nums[i];
                vis[i] = true;
            }
            System.out.println("sum: " + sum);
        }
        System.out.println(sum);
    }


    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            //n = 100000;
            nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Long.parseLong(br.readLine());
                //nums[i] = n;
            }

            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2036 b = new B_2036();
        b.init();
    }
}
