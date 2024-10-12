package b_202410;

import java.io.*;
import java.util.*;

// 241023 골드 3 / 폰트 / 비트마스킹 문제

public class B_9997 {

    final int allAlphabet = (1 << 26) - 1; // 0000 0011 1111 1111 1111 1111 1111 1111
    int[] words = new int[26];
    int n;
    int res = 0;

//    int binaryToDecimal(String str) {
//        return Integer.parseInt(str, 2);
//    }

    public void dfs(int idx, int value) {
        if (idx == n - 1) {
            if (value == allAlphabet) {
                res++;
            }
            return;
        }

        // 해당 문자열을 추가한 경우.
        dfs(idx + 1, value | words[idx+1]);
        // 해당 문자열을 추가 X
        dfs(idx + 1, value);
    }

    public void solve() {
        dfs(-1, 0);
        System.out.println(res);
    }

    public int alphaToBinary(String s)  {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            value |= (1 << c); // 1을 왼쪽으로 c번 이동시킨다. c = 1 -> 0000 0000 0010
        }
        return value;

    }

    public static void main(String[] args) throws Exception {
        B_9997 b = new B_9997();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            words[i] = alphaToBinary(br.readLine());
        }

    }
}
