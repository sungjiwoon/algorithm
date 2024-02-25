package b_13_simulation;

import java.io.*;
import java.util.*;

/** 240225 백준 리모컨 골드 5, 수학, 완탐 */

public class B_1107 {
    static int n;
    static boolean[] channel = new boolean[10];

    private static boolean isOk (int num) {
        char[] ch = String.valueOf(num).toCharArray();
        for (int j = 0; j < ch.length; j++) {
            int idx = ch[j] - '0';
            if (channel[idx]) {
                return false;
            }
        }
        return true;
    }

    private static int solve() {

        int range = 0;
        int near = 100;
        boolean not100 = true;
        if (n == 100) not100 = false;

        while (range <= Math.abs(n - 100)) {

            int minus = n - range;
            if (minus >= 0 && isOk(minus)) {
                if (range + String.valueOf(minus).length() >= Math.abs(n - 100)) {
                    minus = 100;
                    not100 = false;
                }
                near = minus;
                break;
            }

            int plus = n + range;
            if (isOk(plus)) {
                if (range + String.valueOf(plus).length() >= Math.abs(n - 100)) {
                    plus = 100;
                    not100 = false;
                }
                near = plus;
                break;
            }

            if (range >= Math.abs(n - 100)) {
                near = 100;
                not100 = false;
                break;
            }

            range++;

        }

        System.out.println("near : " + near + ", not100 : " + not100);
        int len = not100 ? String.valueOf(near).length() : 0;
        int res = Math.abs(near - n) + len;
        return res;

    }
    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            if (m == 0) return;

            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < m; i++) {
                channel[tmp[i]] = true;
            }

        } catch (Exception e) {}
    }
}
