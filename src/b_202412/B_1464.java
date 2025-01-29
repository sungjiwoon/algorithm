package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 250129 카드 뒤집기 3
public class B_1464 {
    String S;

    void solve() {
        // 뒤집기 -> 맨앞 문자부터 확인
        // 앞 문자보다 크다? > 앞에 배치
        // 앞 문자보다 작다? > 뒤에 배치
        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            if (sb.charAt(i-1) <= S.charAt(i)) {
                sb.insert(0, S.charAt(i));
            } else {
                sb.append(S.charAt(i));
            }
        }
        sb.reverse();
        System.out.println(sb.toString());
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            S = br.readLine();
            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1464 b = new B_1464();
        b.init();
    }
}
