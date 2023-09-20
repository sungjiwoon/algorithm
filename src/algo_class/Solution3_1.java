package algo_class;

import java.util.*;

//학급회장
class Solution3_1 {
    public char solution(String s){

        HashMap<Character, Integer> hm = new HashMap<>();

        int max = 0;
        char answer=' ';
        for (char c : s.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
            if (max < hm.get(c)) {
                max = hm.get(c);
                answer = c;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution3_1 T = new Solution3_1();
        System.out.println(T.solution("BACBACCACCBDEDE"));
        System.out.println(T.solution("AAAAABBCCDDDD"));
        System.out.println(T.solution("AABBCCDDEEABCB"));
    }
}
