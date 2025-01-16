package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 240116 그리디 흙길 보수하기 */
public class B_1911 {
    int n, l;
    long[][] values;

    void solve() {
        init();

        int res = 0;
        Arrays.sort(values, (o1, o2) -> Math.toIntExact(o1[0] - o2[0]));

        long x = 0;
        for (int i = 0; i < n; i++) {
            long st = values[i][0], en = values[i][1];
            if (en <= x) continue;
            if (x < st) x = st;
            int v = (int) Math.ceil((en-x) / (double) l);
            x += (v * l);
            System.out.println(st + "," + en + " => " + v + ", x: " + x);
            res += v;
        }

        System.out.println(res);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nums[0];
            l = nums[1];
            values = new long[n][2];
            for (int i = 0; i < n; i++) {
                values[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1911 b = new B_1911();
        b.solve();
    }
}
