package group_study;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651
// 호첼 대실 (우선순위 큐 + 정렬)
public class 호텔대실 {
    final int 청소시간 = 10;

    int 문자열to시간(String 시간) {
        //15:20 => 15 * 60 + 20
        // 시간을 분으로 바꿔줘야함.
        String[] sp = 시간.split(":");
        int 시 = Integer.parseInt(sp[0]) * 60;
        int 분 = Integer.parseInt(sp[1]);
        return 시 + 분;
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        // 입실 시간 기준으로 정렬.
        Arrays.sort(book_time, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        //퇴실 시간을 최소힙으로 구현할 예정이므로, 그냥 우선순위큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i< book_time.length; i++) {
            int 입실시간 = 문자열to시간(book_time[i][0]);
            int 퇴실시간 = 문자열to시간(book_time[i][1]);

            if (pq.isEmpty()) {
                pq.offer(퇴실시간);
                continue;
            }

            if (pq.peek() + 청소시간 <= 입실시간) {
                pq.poll();
            }
            pq.offer(퇴실시간);

        }


        return pq.size();
    }
}
