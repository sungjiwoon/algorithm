package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/** 240119 문자열 복사, 그리디, 앞에서부터 문자 확인하자.. */
public class B_2195 {
    String S, P;

    void solve() {
        init();

        // 앞에서부터 차례대로 확인
        int idx = 0;
        int cnt = 0;
        int len = P.length();
        for (int i = 0; i < len; i++) {
            if (S.indexOf(P.substring(idx, i+1)) == -1) {
                System.out.println(P.substring(idx, i));
                idx = i;
                cnt++;
            }
        }
        System.out.println(cnt+1);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            S = br.readLine();
            P = br.readLine();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2195 b = new B_2195();
        b.solve();
    }

}
