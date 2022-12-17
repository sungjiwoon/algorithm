import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class B_10845 {
	static int[] queue;
	static int tail, head;
	static int last;
	public static void push(int X) {
		queue[tail++]=X;
	}
	public static int pop() {
		int n = queue[head];
		head++;
		return n;		
	}
	public static int getSize() {
		return tail-head;
	}
	public static int isEmpty() {
		if (tail == head) return 1;
		else return 0;
	}
	public static int front() {
		return queue[head];
	}
	public static int back() {
		return queue[tail-1];
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		queue = new int[N];
		Queue<Integer> q = new LinkedList<Integer>();
		//stack = new int[N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			if (s.startsWith("push")) {
				
				last = Integer.parseInt(s.substring(5));
				//push(n);
				q.offer(last);
			
			} else if (s.equals("pop")) {
				//System.out.println(pop());
				if (!q.isEmpty())
					sb.append(q.poll() + "\n");
				else
					sb.append("-1 \n");	
				
			} else if (s.equals("front")) {
//				System.out.println(getTop());
				if (!q.isEmpty())
					sb.append(q.peek() + "\n");
				else
					sb.append("-1 \n");
			
			} else if (s.equals("back")) {
//				System.out.println(getTop());
				if (!q.isEmpty())
					sb.append(last + "\n");
				else
					sb.append("-1 \n");
			
			} else if (s.equals("size")) {
				sb.append(q.size() + "\n");

			} else if (s.equals("empty")) {
				if (q.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				//sb.append(q.isEmpty() + "\n");
			}
			
			
		}
		System.out.print(sb);
	}
}
