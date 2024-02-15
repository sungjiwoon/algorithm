package hell_study;

import java.io.*;
import java.util.*;

/** 240215 백준 20529 실버 1 비둘기집 원리 */
public class B_20529 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] mbti = br.readLine().split(" ");
            if (n >= 33) {
                // mbti 는 16명이므로, 33명 이상부터는 같은 mbti 있는 멤버가 무조건 3명 이상은 나온다. 3명 이상부터는 최솟값은 0이므로 계산하지않는다.
                sb.append("0\n");
                continue;
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int cnt = 0;
                        for (int l = 0; l < 4; l++) {
                            cnt += (mbti[i].charAt(l) != mbti[j].charAt(l) ? 1 : 0);
                            cnt += (mbti[i].charAt(l) != mbti[k].charAt(l) ? 1 : 0);
                            cnt += (mbti[j].charAt(l) != mbti[k].charAt(l) ? 1 : 0);
                        }
                        res = Math.min(res, cnt);
                    }
                }
            }
            sb.append(res + "\n");
        }

        System.out.println(sb);
    }
}
