package b_22_priority_queue;

import java.util.*;

/*
 * 이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

명령어	수신 탑(높이)
I 숫자	큐에 주어진 숫자를 삽입합니다.
D 1	큐에서 최댓값을 삭제합니다.
D -1	큐에서 최솟값을 삭제합니다.
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 
비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 */

public class P_230519_doublequeue {
	public int[] solution(String[] operations) {
        int n = operations.length;
        PriorityQueue<Integer> p1 = new PriorityQueue<>(); //최솟값 우선순위 큐 
        PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder()); //최댓값 우선순위 큐
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            String oper = st.nextToken();
            int v = Integer.parseInt(st.nextToken());
            if (oper.equals("I")) {
                p1.add(v);
                p2.add(v);
            } else if (oper.equals("D")) {
                if (p1.isEmpty()) continue;
                if (v == 1) { //최댓값 삭제.
                   int max = p2.poll();
                    p1.remove(max);
                } else if (v == -1) {
                    int min = p1.poll();
                    p2.remove(min);
                } //최솟값 삭제.                 
            }
        } 
        int[] answer = new int[2];
        if (!p1.isEmpty()) {
            answer[0] = p2.poll();
            answer[1] = p1.poll();
        } 
        
        return answer;
    }
}
