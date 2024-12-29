package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B_15787 {
    int n, m;
    int[] train;

    private void solve() {
        init();

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(train[i])) continue;
            map.put(train[i], 1);
            res++;
        }
        System.out.println(res);

    }
    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            StringBuilder sb = new StringBuilder();
            n = tmp[0];
            m = tmp[1];

            train = new int[n+1];
            for (int i = 0; i < m; i++) {
                tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int k = tmp[1];
                int x;
                if (tmp[0] == 1) {
                    x = tmp[2];
                    train[k] |= (1 << (x-1)); // x-1 자리에 1을 킨다.
                } else if (tmp[0] == 2) {
                    x = tmp[2];
                    train[k] &= ~(1 << (x-1)); // x-1 자리에 1을 끈다.
                } else if (tmp[0] == 3) {

                    train[k] <<= 1; // 뒤로 이동
                    train[k] &= (1 << 20) - 1; // 20bit 이후의 값은 모두 제거
                } else if (tmp[0] == 4) {
                    train[k] >>= 1; // 앞으로 이동
                }
                sb.append(
                        String.format("\n%d) train[%d] = %20s", tmp[0], k,
                                Integer.toBinaryString(train[k]).replaceAll(" ", "0")));

            }
            System.out.println(sb);

        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_15787 b = new B_15787();
        b.solve();
    }
}
