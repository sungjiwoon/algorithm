package b_07_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * 실버4
 * 바킹독 기본문제
 * 덱을 배열로 구현을 먼저함.
 * 
 */
public class B_10866 {
	static int head, tail;
	static int[] deque;
	static int front() {
		if (isEmpty()== 1) return -1;
		return deque[head];
	}
	static int back() {
		if (isEmpty()== 1) return -1;
		return deque[tail-1];
	}
	static void push_front(int X) {
		deque[--head] = X;
	}
	static void push_back(int X) {
		deque[tail++] = X;
	}
	static int pop_front() {
		if (isEmpty() == 1) return -1;
		return deque[head++];
	}
	static int pop_back() {
		if (isEmpty() == 1) return -1;
		int n = deque[tail-1];
		tail--;
		return n;
	}
	static int size() {
		return tail-head;
	}
	static int isEmpty() {
		if (size() == 0) return 1;
		return 0;
	}
	
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deq = new LinkedList<>();
		
		//deque = new int[N*2+1]; //앞 뒤에서 추출해야하므로, 2배+1
//		head = N/2;
//		tail = N/2;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n;
			switch (st.nextToken()) {
			
			case "push_back" :
				//push_back(Integer.parseInt(st.nextToken()));
				deq.addLast(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_front" :
//				push_front(Integer.parseInt(st.nextToken()));
				deq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			
			case "pop_front" :
//				n = pop_front();
				if (deq.isEmpty()) sb.append("-1\n");
				else sb.append(deq.removeFirst()+"\n");
//				sb.append(n + "\n");
				break;
			
			case "pop_back" :
//				n = pop_back();
//				sb.append(n + "\n");
				if (deq.isEmpty()) sb.append("-1\n");
				else sb.append(deq.removeLast()+"\n");
				break;
				
			case "front" :
//				n = front();
//				sb.append(n + "\n");
				if (deq.isEmpty()) sb.append("-1\n");
				else sb.append(deq.peekFirst()+"\n");
				break;
			
			case "back" :
//				n = back();
//				sb.append(n + "\n");
				if (deq.isEmpty()) sb.append("-1\n");
				else sb.append(deq.peekLast()+"\n");
				break;
			
			case "empty" :
//				n = isEmpty();
//				sb.append(n + "\n");
				if (deq.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
				
			case "size" :
//				n = size();
//				sb.append(n + "\n");
				sb.append(deq.size()+"\n");
				break;
		
			}
			
			
		}
		System.out.println(sb);
		
	}
}
