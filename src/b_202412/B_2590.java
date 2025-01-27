package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 240126 색종이 그리디 */
public class B_2590 {
    int[] nums = new int[7];

    void solve() {
        int cnt = 0;
        for (int i = 6; i >= 1; i--) {
            if (i == 6) {
                cnt += nums[6];
            } else if (i == 5) {
                // 색종이 한장(36)에 25 사이즈가 들어감. 11사이즈 만큼 1이 차감
                cnt += nums[5];

                if (nums[1] > 11 * nums[5]) {
                    nums[1] -= (11 * nums[5]);
                } else {
                    int v = nums[1] / 11;
                    nums[1] -= 11 * v;
                    if (nums[1] < 11 && v < nums[5]) nums[1] = 0;
                }

            } else if (i == 4) {
                // 4 사이즈이면, 2나 1이 차감
                cnt += nums[4];

                // 2먼저 차감 (36 - 16 = 20 / (2*2) = 5장이 필요)



            } else if (i == 3) {

                cnt += (nums[3] / 4);
                if (nums[3] % 4 == 1) {

                } else if (nums[3] % 4 == 2) {

                } else if (nums[3] % 4 == 3) {

                } else {

                }



            } else if (i == 2) {
                cnt += (nums[2] / 9);

                // 나머지는 1로 채움
                if (nums[2] % 9 == 0) continue;
                int remain = 36 - (2 * 2 * nums[2] % 9);
                if (nums[1] >= remain) nums[1] -= remain;
                else nums[1] = 0;

            } else if (i == 1) {
                cnt += (nums[1] / 36);
                if (nums[1] % 36 > 0) {
                    cnt++;
                }
            }
        }

    }


    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            nums[1] = Integer.parseInt(br.readLine());
            nums[2] = Integer.parseInt(br.readLine());
            nums[3] = Integer.parseInt(br.readLine());
            nums[4] = Integer.parseInt(br.readLine());
            nums[5] = Integer.parseInt(br.readLine());
            nums[6] = Integer.parseInt(br.readLine());

            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2590 b = new B_2590();
        b.init();
    }
}
