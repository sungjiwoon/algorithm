package b_22_priority_queue;

import java.util.*;

public class PriorityQueueTest {
	public void work() {
		
		//1) integer Ÿ��, ���� ���� ��. 
		PriorityQueue<Integer> qu1 = new PriorityQueue<>();
		
		//2) integer Ÿ��, ���� ���� ��. 
		PriorityQueue<Integer> qu2 = new PriorityQueue<>(Collections.reverseOrder());
		
		//3) String Ÿ��, ���� ���ڿ� ��. 
		PriorityQueue<String> qu3 = new PriorityQueue<>();
		
		//4) String Ÿ��, ���� ���ڿ� ��. 
		PriorityQueue<String> qu4 = new PriorityQueue<>(Collections.reverseOrder());
		
		qu1.add(1);
		qu1.add(21);
		qu1.add(35);
		qu1.add(15);
		System.out.println(qu1);
		
		qu2.add(1);
		qu2.add(21);
		qu2.add(35);
		qu2.add(15);
		System.out.println(qu2);
		
		qu3.add("abc");
		qu3.add("abc");
		qu3.add("agh");
		qu3.add("bgd");
		qu3.add(".");
		qu3.add("ijk");
		System.out.println("String ���� ������� : "+ qu3);
		
		qu4.add("abc");
		qu4.add("abc");
		qu4.add("agh");
		qu4.add("bgd");
		qu4.add(".");
		qu4.add("ijk");
		System.out.println("String ���� ������� : "+ qu4);
		
		System.out.println("-------qu1 ���� -------");
		/* ��� */
		Iterator it = qu1.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

		qu1.poll();
		System.out.println(qu1);
		qu1.poll();
		System.out.println(qu1);
		qu1.poll();
		System.out.println(qu1);
		
		
		
		System.out.println("-------qu2 ���� -------");
		System.out.println(qu2);
		qu2.poll();
		System.out.println(qu2);		
		qu2.poll();
		System.out.println(qu2);
		qu2.poll();
		System.out.println(qu2);
		
		
	}
}
