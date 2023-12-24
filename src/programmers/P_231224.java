package programmers;
import java.util.*;

/**
 * 231224 프로그래머스 레벨2 할인행사
 * hashMap , dp
 */
public class P_231224 {
    public int solution(String[] want, int[] number, String[] discount) {
        int len = discount.length;
        int total = 0;
        int[] dp = new int[len + 1]; //i ~ i + 9 동안 물품, 수량이 모두 맞을 때 +1
        Map<String, Integer> map = new HashMap<>(); //10일동안 물품당 할인하는 갯수
        Map<String, Integer> wantCnt = new HashMap<>(); //각 물품 별 원하는 갯수.

        for (int i = 0; i < want.length; i++) {
            String w = want[i];
            map.put(w, 0);
            wantCnt.put(w, number[i]);
            total += number[i];
        }

        for (int i = 0; i < 10; i++) {
            String dis = discount[i];
            if (map.containsKey(dis)) {
                map.put(dis, map.get(dis) + 1);
                if (map.get(dis) == wantCnt.get(dis)) dp[0]++;
            }
        }

        int answer = 0;
        if (dp[0] == wantCnt.size()) answer++;

        for (int i = 1; i < len; i++) {
            String before = discount[i - 1];
            String newer = "";

            if (i + 9 < len) newer = discount[i + 9];
            else newer = discount[len - 1];

            //1. before을 뺀다.
            if (map.containsKey(before)) {
                map.put(before, map.get(before) - 1);
            }

            //2. newer 을 추가한다.
            if (map.containsKey(newer) && i + 9 < len) {
                map.put(newer, map.get(newer) + 1);
            }

            for (String m : map.keySet()) {
                if (map.get(m) >= wantCnt.get(m)) dp[i]++;
            }

            if (dp[i] == wantCnt.size()) {
                answer++;
            }

        }

        return answer;
    }
}

