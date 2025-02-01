package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 250201 방 번호, 그리디, DP

public class B_1082 {
    int n, m;
    int[] p;

    void solve() {
        String[] dp = new String[m+1];
        Arrays.fill(dp, "");
        // dp[i] -> i원일 때 만들 수 있는 최대 수

        for (int i = 0; i <= m; i++) {
            String v = dp[i];
            for (int j = 0; j < n; j++) {
                if (i + p[j] > m) continue;
                String comV = dp[i+p[j]];
                String nv = v + String.valueOf(j);
//                System.out.println(String.format("i[%d],j[%d]- dp[%d]=%s, nv=%s", i,j,(i+p[j]), comV, nv));
                if (nv.startsWith("00")) continue;
                if (comV.length() > nv.length()) continue;
                else if (comV.length() == nv.length()) {
                    if (comV.compareTo(nv) < 0) { // comV < nv
                        dp[i+p[j]] = nv;
//                        System.out.println(comV +" " + nv + " " + dp[i+p[j]]);
                    }
                } else {
                    dp[i+p[j]] = nv;
                }
            }
        }

        String max = "";
//        System.out.println("[DP]");
        for (int i = 0; i <= m; i++) {
//            System.out.println(i + ": " + dp[i]);
            if (max.length() == dp[i].length()) {
                if (max.compareTo(dp[i]) < 0) {
                    max = dp[i];
                }
            } else if (max.length() < dp[i].length()) {
                max = dp[i];
            }
        }
        System.out.println(max);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            p = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            m = Integer.parseInt(br.readLine());

            solve();
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_1082 b = new B_1082();
        b.init();

    }
}
