import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//스택은 dfs 큐는 bfs에서 쓰인다!!
public class B_10828 {
	//static int[] stack;
//	static int pos;
//	public void push(int X) {
//		stack[pos++]=X;
//	}
//	public int pop() {
//		if (isEmpty() == 1) return -1;
//		int n = stack[pos-1];
//		pos--;
//		return n;
//		
//	}
//	public int getSize() {
//		return pos;
//	}
//	public int isEmpty() {
//		if (pos > 0) return 0;
//		else return 1;
//	}
//	public int getTop() {
//		if (pos == 0) return -1;
//		return stack[pos-1];
//	}
	//스택 구현 
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		//stack = new int[N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			if (s.startsWith("push")) {
				int n = Integer.parseInt(s.substring(5));
				//push(n);
				stack.push(n);
			} else if (s.equals("pop")) {
				//System.out.println(pop());
				if (!stack.isEmpty())
					sb.append(stack.pop() + "\n");
				else
					sb.append("-1 \n");
			} else if (s.equals("top")) {
//				System.out.println(getTop());
				if (!stack.isEmpty())
					sb.append(stack.peek() + "\n");
				else
					sb.append("-1 \n");
			} else if (s.equals("size")) {
				if (!stack.isEmpty())
					sb.append(stack.size() + "\n");
				else
					sb.append("-1 \n");
			} else if (s.equals("empty")) {
				if (!stack.isEmpty())
					sb.append("0\n");
				else
					sb.append("1 \n");
			}
			
			
		}
		System.out.print(sb);
	}
}
