package programmers;

import java.util.*;

/**
 * 240103 프로그래머스 레벨 2, 큰 수 만들기
 * 그리디, 우선순위 큐 사용
 */

public class P_240103 {
    public String solution(String number, int k) {
        //k개의 수를 제거한다.
        //len - k 개의 글자수를 구해야한다.

        int len = number.length();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2[0] == o1[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        for (int i = 0; i < k + 1; i++) {
            int nc = Integer.parseInt(String.valueOf(number.charAt(i)));
            pq.add(new int[]{nc, i});
        }

        int st = -1;
        for (int i = k + 1; i < len; i++) {
            while (!pq.isEmpty() && pq.peek()[1] < st) {
                pq.poll();
            }

            int[] nxt = pq.poll();
            st = nxt[1];
            sb.append(nxt[0]);

            int nc = Integer.parseInt(String.valueOf(number.charAt(i)));
            pq.add(new int[]{nc, i});

        }

        while (!pq.isEmpty() && pq.peek()[1] < st) {
            pq.poll();
        }

        int[] nxt = pq.poll();
        sb.append(nxt[0]);

        return sb.toString();
    }
}

