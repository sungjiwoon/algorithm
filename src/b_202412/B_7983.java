package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 240119 그리디, 내일 할거야 https://www.acmicpc.net/problem/7983 */
public class B_7983 {

    int n;
    int[][] days;

    void solve() {
        init();

        Arrays.sort(days, (o1, o2) -> o2[1]-o1[1]);
        int day = days[0][1] - days[0][0]; //최초 시작 날짜
        for (int i = 1; i < n; i++) {
            int d = days[i][0], en = days[i][1];
            if (en < day) {
                day = en;
            }
            day -= d;
        }
        System.out.println(day);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            days = new int[n][2];
            for (int i = 0; i < n; i++) {
                days[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_7983 b = new B_7983();
        b.solve();
    }
}
