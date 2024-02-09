package hell_study;

import java.util.*;
import java.io.*;

/**
 * 패션왕 신해빈 (실버 3)
 *
 * 모든 옷의 가짓수 + 1 해서 곱해준 다음 -1 를 해준다.
 * -1를 해주는 이유 : 알몸인 경우.
 */
public class B_9375 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] sp = br.readLine().split(" ");
                map.put(sp[1], map.getOrDefault(sp[1], 0) + 1);
            }

            long res = 1;
            for (String key : map.keySet()) {
                res *= map.get(key) + 1;
            }

            sb.append(res - 1).append("\n");
        }
        System.out.println(sb);
    }
}
