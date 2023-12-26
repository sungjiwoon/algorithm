package programmers;

import java.util.*;

/**
 * 231227 프로그래머스 숫자 게임 (레벨3)
 * 큐, 정렬
 */
public class P_231226 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        Queue<Integer> qu = new LinkedList<>();
        for (int b : B) {
            qu.add(b);
        }

        for (int a : A) {
            while (!qu.isEmpty() && qu.peek() <= a) {
                qu.poll();
            }
            if (qu.isEmpty()) break;
            int b = qu.poll();
            answer++;
        }

        return answer;
    }
}
