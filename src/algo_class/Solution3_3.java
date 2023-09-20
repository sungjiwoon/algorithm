package algo_class;

import java.util.*;

public class Solution3_3 {
    public int solution(String s){
        int answer = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c: s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c,0) + 1);
        }

        int max = 0;
        boolean ok = false; //3이상의 홀수가 참여했는지 확인.
        for (Character iter : hm.keySet()) {
            if (hm.get(iter) % 2 == 0) {
                answer += hm.get(iter);
            } else {
                if (hm.get(iter) >= 3) {
                    answer += hm.get(iter) - 1;
                    ok = true;
                }
                max = Math.max(hm.get(iter), max);
            }
        }
        if (ok) answer++;
        return answer;
    }

    public static void main(String[] args){
        Solution3_3 T = new Solution3_3();
        System.out.println(T.solution("abcbbbccaaeee"));
        System.out.println(T.solution("aabbccddee"));
        System.out.println(T.solution("fgfgabtetaaaetytceefcecekefefkccckbsgaafffg"));
        System.out.println(T.solution("aabcefagcefbcabbcc"));
        System.out.println(T.solution("abcbbbccaa"));
    }
}
