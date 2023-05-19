package b_22_priority_queue;

import java.util.*;

/*
 * ���� �켱���� ť�� ���� ������ �� �� �ִ� �ڷᱸ���� ���մϴ�.

��ɾ�	���� ž(����)
I ����	ť�� �־��� ���ڸ� �����մϴ�.
D 1	ť���� �ִ��� �����մϴ�.
D -1	ť���� �ּڰ��� �����մϴ�.
���� �켱���� ť�� �� ���� operations�� �Ű������� �־��� ��, ��� ������ ó���� �� ť�� ��������� [0,0] 
������� ������ [�ִ�, �ּڰ�]�� return �ϵ��� solution �Լ��� �������ּ���.
 */

public class P_230519_doublequeue {
	public int[] solution(String[] operations) {
        int n = operations.length;
        PriorityQueue<Integer> p1 = new PriorityQueue<>(); //�ּڰ� �켱���� ť 
        PriorityQueue<Integer> p2 = new PriorityQueue<>(Collections.reverseOrder()); //�ִ� �켱���� ť
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(operations[i], " ");
            String oper = st.nextToken();
            int v = Integer.parseInt(st.nextToken());
            if (oper.equals("I")) {
                p1.add(v);
                p2.add(v);
            } else if (oper.equals("D")) {
                if (p1.isEmpty()) continue;
                if (v == 1) { //�ִ� ����.
                   int max = p2.poll();
                    p1.remove(max);
                } else if (v == -1) {
                    int min = p1.poll();
                    p2.remove(min);
                } //�ּڰ� ����.                 
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
