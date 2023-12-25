package programmers;

import java.util.*;

/**
 * 프로그래머스 레벨 3 단속카메라
 * 그리디, 정렬, Queue
 */

public class P_231225 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        Queue<int[]> qu = new LinkedList<>();
        for (int[] ro : routes) {
            qu.add(ro);
            //System.out.println(ro[0] + " " + ro[1]);
        }

        int answer = 0;
        while (!qu.isEmpty()) {
            int[] ro = qu.poll();
            while (!qu.isEmpty() && qu.peek()[0] <= ro[1]) {
                qu.poll();
                //System.out.println(qu.poll()[0]);
            }
            answer++;
        }

        return answer;
    }
}
