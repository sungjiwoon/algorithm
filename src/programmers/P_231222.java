package programmers;

import java.util.*;

/**
 * 231221 프로그래머스 2단계 롤케이크 자르기
 * set, hashmap
 */
public class P_231222 {
    public int solution(int[] topping) {
        Set<Integer> s1 = new HashSet<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        Set<Integer> s2 = new HashSet<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = topping.length - 1; i >= 1; i--) {
            s2.add(topping[i]);
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }

        s1.add(topping[0]);
        map1.put(topping[0], 1);

        int answer = 0;
        if (s1.size() == s2.size()) answer++;

        for (int i = 1; i < topping.length; i++) {
            int num = topping[i];
            s1.add(num);

            if (map2.get(num) == 1) {
                s2.remove(num);
                map2.put(num, 0);
            } else if (map2.get(num) > 1) {
                map2.put(num, map2.get(num) - 1);
            }

            if (s1.size() == s2.size()) answer++;
        }

        return answer;
    }
}
