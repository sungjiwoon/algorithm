package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_21758 {
    int n;
    int[] nums;

    void solve() {
        init();

        int res = 0;

        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i-1] + nums[i];
        }

        int a = 0; // 고정
        int total = sums[n-1] * 2;

        // (sums[a] + sums[b] + nums[b]) // 최소
        // sums[b] + nums[b] -> 최소 구간 찾기

        int bMin = total;
        for (int i = 1; i < n; i++) {
            bMin = Math.min(bMin, sums[i] + nums[i]);
        }

        res = total - (sums[a] + bMin);

        // 반대로 계산
        a = n-1;
        int[] sums2 = new int[n];
        sums2[a] = nums[a];
//        System.out.println("sums2["+a+"] = " + sums2[a]);
        for (int i = n-2; i >= 0; i--) {
            sums2[i] = sums2[i+1] + nums[i];
//            System.out.println("sums2["+i+"] = " + sums2[i]);
        }
        bMin = total;
//        System.out.println("total = " + total);
        for (int i = n-2; i >= 0; i--) {
            bMin = Math.min(bMin, sums2[i] + nums[i]);
//            System.out.println(i + ": " + bMin);
        }

        res = Math.max(total - (sums[a] + bMin), res);

        // 꿀통이 a, b 가운데 있ㅎ을 때.
        // a와 b는 맨끝 고정이다.

        int c = 0;
        for (int i = 1; i < n-1; i++) {
            c = Math.max(c, sums[i] + sums2[i] - nums[0] - nums[n-1]);
        }

        res = Math.max(res, c);
        System.out.println(res);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_21758 b = new B_21758();
        b.solve();
    }

}
