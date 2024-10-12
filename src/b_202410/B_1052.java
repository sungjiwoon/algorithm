package b_202410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 241013 물병 골드5 비트마스킹 */

public class B_1052 {
    int n, k;

    public int count1(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
        }
        return cnt;
    }

    public void solve() {
        String ns = Integer.toBinaryString(n);
        int res = -1;
        int now = n;

        while (true) {
            int cnt_n = count1(ns);
            if (cnt_n <= k) {
                res = now - n;
                break;
            }
            now++;
            if (now < 0) break;
            ns = Integer.toBinaryString(now);
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        B_1052 b = new B_1052();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }
}
