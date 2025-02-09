package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 250209 도둑 골드4
public class B_13422 {
    int n, m, k;
    int[] money;

    private void solve() {
        // m만큼 연속된 수만큼 돈을 훔쳐야 함
        long[] sumDp = new long[n+1];
        // sumDp[0] - > money[0]
        // sumDp[1] -> sumDp[0] + money[1];
        sumDp[1] = money[1];
        for (int i = 2; i <= n; i++) {
            sumDp[i] = sumDp[i-1] + money[i];
        }

        int st = 0, en = m;
        long value = 0;
        int res = 0;
        while (en <= n + (m-1)) {
            value = k+1;
            if (en <= n) {
                value = sumDp[en] - sumDp[st];
                if (value < k) {
                    System.out.println("sumDp["+en+"]-sumDp["+st+"] = " + value + " ");
                }
            } else if (n != m){
                value = sumDp[en-n] + sumDp[n] - sumDp[st];
                if (value < k) {
                    System.out.println(String.format("sumDp[%d] + sumDp[%d] - sumDp[%d] = %d",(en-n),(n),st, value));
                }
            }
            if (value < k) {

                res++;
            }
            st++;
            en++;
        }


        System.out.println(res);
    }


    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for (int t = 1; t <= T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine(), " ");
                money = new int[n+1];
                for (int i = 1; i <= n; i++) {
                    money[i] = Integer.parseInt(st.nextToken());
                }
               solve();
            }
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_13422 b = new B_13422();
        b.init();
    }
}
