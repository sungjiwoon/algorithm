package b_202410;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** 241013 압축 (골4)
 * 재귀
 */
public class B_1662 {

    String str;
    int idx = 0;
    public int sum(int k) {
        int q = 0;
        while (idx < str.length()) {
            if (str.charAt(idx) == ')') {
                break;
            }
            if (idx + 1 < str.length() && str.charAt(idx + 1) == '(') {
                int newK = Integer.parseInt(String.valueOf(str.charAt(idx)));
                idx += 2;
                q += sum(newK);
            } else {
                q++;
            }
            idx++;
        }

        return k * q;
    }

    public void solve() {
        int res = sum(1);
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        B_1662 b = new B_1662();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }
}
