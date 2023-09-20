package algo_class;

import java.util.*;
//같은 빈도수 구하기 .
public class Solution3_2 {
    public int[] solution(String s){


        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int max = 0;
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c,0) + 1);
            max = Math.max(hm.get(c), max);
        }
        int[] answer = new int[hm.size()];
        for (int i = 0; i < hm.size(); i++) {

        }
        return answer;
    }

    public static void main(String[] args){
        Solution3_2 T = new Solution3_2();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
