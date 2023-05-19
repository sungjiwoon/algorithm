package programmers;

import java.util.PriorityQueue;


/*
 * �ſ� ���� �����ϴ� Leo�� ��� ������ ���ں� ������ K �̻����� ����� �ͽ��ϴ�. ��� ������ ���ں� ������ K �̻����� ����� ����
 *  Leo�� ���ں� ������ ���� ���� �� ���� ������ �Ʒ��� ���� Ư���� ������� ���� ���ο� ������ ����ϴ�.

���� ������ ���ں� ���� = ���� ���� ���� ������ ���ں� ���� + (�� ��°�� ���� ���� ������ ���ں� ���� * 2)
Leo�� ��� ������ ���ں� ������ K �̻��� �� ������ �ݺ��Ͽ� �����ϴ�.
Leo�� ���� ������ ���ں� ������ ���� �迭 scoville�� ���ϴ� ���ں� ���� K�� �־��� ��, 
��� ������ ���ں� ������ K �̻����� ����� ���� ����� �ϴ� �ּ� Ƚ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� Ǯ�� : �켱����ť�� Ǯ����. �׷���. queue�� ����� �� üũ�ؾ��Ѵ�. 
 * 
 */
public class P_230519_Heap {
	 public int solution(int[] scoville, int K) {
	        PriorityQueue<Long> qu = new PriorityQueue<>();
	        for (int i = 0; i < scoville.length; i++) {
	            qu.add((long)(scoville[i]));
	        }
	        
	        int cnt = 0;
	        while (qu.peek() < K) {
	            long o1 = qu.poll();
	            long o2 = qu.poll();
	            long add = o1+ o2*2;
	            qu.add(add);
	            cnt++;
	            if (qu.size() < 2 && qu.peek() < K) {
	                cnt = -1;
	                break;
	            }
	        }
	        int answer = cnt;
	        return answer;
	    }
}
