package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 250130 지뢰찾기 ver2 https://www.acmicpc.net/problem/9082
public class B_9082 {
    int n;
    int[] dx = {-1, 0, 1};
    StringBuilder sb = new StringBuilder();
    int[] hint;
    char[] map; // # -> 숨겨짐, * -> 지뢰

    void solve() {

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (map[i] == '*') {

                for (int k = 0; k < 3; k++) {
                    int dk = i + dx[k];
                    if (dk < 0 || dk >= n) continue;
                    hint[dk]--;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (map[i] == '#') {
                boolean can = true;
                for (int k = 0; k < 3; k++) {
                    int dk = i + dx[k];
                    if (dk < 0 || dk >= n) continue;
                    if (hint[dk] == 0) {
                        can = false;
                        break;
                    }
                }
                if (can) {
                    // 지뢰가 될 수 있는 자리임
                    for (int k = 0; k < 3; k++) {
                        int dk = i + dx[k];
                        if (dk <0 || dk >= n) continue;
                        hint[dk]--;
                    }
                    map[i] = '*';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (map[i] == '*') res++;
        }


        sb.append(res+"\n");

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for (int t = 0; t < T; t++) {
                n = Integer.parseInt(br.readLine());
                hint = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
                map = br.readLine().toCharArray();
                solve();
            }
            System.out.println(sb);
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_9082 b = new B_9082();
        b.init();
    }
}
