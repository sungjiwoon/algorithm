package algo_class;

import java.util.LinkedList;

//연속된 문자열 지우기.
public class Solution4_1 {
    public String solution(String s) {
        StringBuilder str = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (stack.peekFirst() == c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            str.append(stack.pollLast());
        }

        return str.toString();

    }
    public static void main(String[] args) {
        Solution4_1 T = new Solution4_1();
        System.out.println(T.solution("acbbcaa"));
        System.out.println(T.solution("bacccaba"));
        System.out.println(T.solution("aabaababbaa"));
        System.out.println(T.solution("bcaacccbaabccabbaa"));
        System.out.println(T.solution("cacaabbc"));
    }
}
