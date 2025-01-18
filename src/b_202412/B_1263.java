package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/** 240118 그리디 시간관리 */
public class B_1263 {

    int n;
    int[][] times;

    void solve() {
        init();

        Arrays.sort(times, (o1, o2) -> o2[1]-o1[1]);
        int time = times[0][1] - times[0][0];
        for (int i = 1; i < n; i++) {
            int m = times[i][0], en = times[i][1];
            if (time > en) {
                time = en;
            }
            time -= m;
        }
        if (time < 0) time = -1;
        System.out.println(time);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            times = new int[n][2];
            for (int i = 0; i < n; i++) {
                times[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1263 b = new B_1263();
        b.solve();
    }
}
