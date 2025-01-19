package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/** 240120 그리디 아름다운 문자열 */
public class B_25424 {
    String S, T;

    void solve() {
        init();

        // T -> S
        // 순서가 맞으면 됨
        Queue<Integer>[] quList = new LinkedList[27];
        for (int i = 0; i < 27; i++) {
            quList[i] = new LinkedList<>();
        }

        for (int i = 0; i < S.length(); i++) {
            int ch = S.charAt(i) - 'a';
            quList[ch].add(i);
        }

        int res = 0;

        int st = T.charAt(0) - 'a';
        Queue<Integer> qu = quList[st];
        while (!qu.isEmpty()) {
            int q = qu.poll();

            boolean ok = true;
            for (int i = 1; i < T.length(); i++) {
                int ch = T.charAt(i) - 'a';
                Queue<Integer> qu2 = quList[ch];
                while (!qu2.isEmpty() && qu2.peek() <= q) {
                    // 첫번째 글자의 인덱스 값보다 작으면 사용될 인덱스가 아니기 때문에 out
                    qu2.poll();
                }
                if (qu2.isEmpty()) {
                    ok = false;
                    break;
                }
                q = qu2.poll();
            }
            if (ok) {
                res++;
            }
        }
        System.out.println(res);
    }
    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            S = br.readLine();
            T = br.readLine();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_25424 b = new B_25424();
        b.solve();
    }
}
