package algo_class;
import java.util.*;

public class P_49993 {
    static HashMap<Character, Integer> sequence = new HashMap<>();
    public boolean ok(String s) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            if (!sequence.containsKey(s.charAt(j))) continue;
            if (stack.isEmpty()) {
                if (sequence.get(s.charAt(j)) > 0) return false;
                stack.push(s.charAt(j));
            } else {
                if (sequence.get(s.charAt(j)) - sequence.get(stack.peek()) != 1) return false;
                stack.push(s.charAt(j));


            }
        }
        return true;
    }
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill.length(); i++) {
            sequence.put(skill.charAt(i), i);
        }


        for (int i = 0; i < skill_trees.length; i++) {
            if (ok(skill_trees[i])) answer++;
        }
        return answer;
    }
}
