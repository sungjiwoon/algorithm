package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
// 250131 세 수, 두 M https://www.acmicpc.net/problem/2405
public class B_2405 {
    int n;
    int[] nums;

    private void solve() {
        Arrays.sort(nums);

        // 중위값과 평균값의 차이의 3배
        // (b-(a+b+c)/3)*3 = 3b-(a+b+c) = 2b-a-c 의 최댓값 (혹은 a-2b+c)

        // 1. a를 맨앞에 고정한 다음 b, c를 찾는 다.
        int res = Integer.MIN_VALUE;
        int a = nums[0];
        int b = 0, c = 0;
        int sum = 0;
        for (int i = 1; i < n-1; i++) {
            b = nums[i];
            c = nums[i+1];

            sum = a+b+c;
            if (sum/3 < b) {
                res = Math.max(res, 2*b-a-c);
            } else {
                res = Math.max(a-2*b+c, res);
            }

        }

        // 2. a,b를 움직인다. c는 마지막에 고정
        c = nums[n-1];
        for (int i = 0; i < n-2; i++) {
            a = nums[i];
            b = nums[i+1];
            sum = a+b+c;
            if (sum/3 < b) {
                res = Math.max(res, 2*b-a-c);
            } else {
                res = Math.max(a-2*b+c, res);
            }
        }

        // 3. a와 c 고정 후 b를 움직인다.
        a = nums[0];
        c = nums[n-1];
        for (int i = 1; i < n-1; i++) {
            b = nums[i];
            sum = a+b+c;
            if (sum/3 < b) {
                res = Math.max(res, 2*b-a-c);
            } else {
                res = Math.max(a-2*b+c, res);
            }
        }
        System.out.println(res);


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
        B_2405 b = new B_2405();
        b.init();
    }

}
