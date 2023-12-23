package programmers;
import java.util.*;


/**
 * 프로그래머스 lv 3 야근지수
 * 우선순위큐
 */
public class P_231223 {
    public long solution(int n, int[] works) {
        Arrays.sort(works);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int w : works) {
            pq.add(w);
        }

        while (n != 0) {
            int p = pq.poll();
            if (p == 0) {
                pq.add(0);
                n--;
                continue;
            }
            pq.add(p - 1);
            n--;
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }


        return answer;
    }
}

