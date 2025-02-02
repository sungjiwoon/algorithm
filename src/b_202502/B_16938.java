package b_202502;

import java.io.*;
import java.util.*;
// 250202 캠프 준비 비트마스킹 골드 5
public class B_16938 {
    int n, l, r, x;
    int ans = 0;
    int[] a;
    void solve() {

        for (int bit = 0; bit <= (1 << n); bit++) {
            int st = Integer.MAX_VALUE;
            int en = Integer.MIN_VALUE;
            int cnt = 0;
            int sum = 0;

            // 비트마스킹의 갯수는 2의 n승만큼이다.
            // 이 중 2개 이상이 선택되어 있는지 확인한다.

            for (int i = 0; i < n; i++) {
                if ((bit & (1 << i)) > 0) { // i자리에 1이 켜져있는지 확인한다.
                    cnt++;
                    st = Math.min(st, a[i]);
                    en = Math.max(en, a[i]);
                    sum += a[i];
                }
            }

            if (cnt >= 2 && sum >= l && sum <= r && en - st >= x) {
                ans++;
            }
        }
        System.out.println(ans);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_16938 b = new B_16938();
        b.init();
    }
}
