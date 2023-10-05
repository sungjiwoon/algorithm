package study_alone;
import java.util.*;

/*

요격시스템 (레벨2)
https://school.programmers.co.kr/learn/courses/30/lessons/181188
그리디 알고리즘.
 */
public class P_181188 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1,o2)->o1[0]-o2[0]);

        /*
        순서대로 계ㅅ산하여 스택에 담기는 요격 (x,y)는 요격이 발사할 x좌표의 단위거리? 를 나타냄.
         */

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < targets.length; i++) {
            int x = targets[i][0];
            int y = targets[i][1];

            if (stack.isEmpty()) {
                stack.push(new int[]{x,y});
                continue;
            }

            int[] attack = stack.peek();
            if (attack[1] <= x) {
                stack.push(new int[]{x,y});
            } else {
                stack.pop();
                attack[0] = x > attack[0] ? attack[0] : x;
                attack[1] = y > attack[1] ? attack[1] : y;
                stack.push(attack);
            }
        }
        int answer = stack.size();

        return answer;
    }
}
