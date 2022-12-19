package b_05_stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class B_1874 {
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		int i = 1;
		int index = 0;
		while (i <= N) {
			stack.push(i);
			sb.append("+\n");
			
			while (!stack.isEmpty() && stack.peek().equals(nums[index])) {
				index++;
				stack.pop();
				sb.append("-\n");
			}
			
			i++;
		}
		//System.out.println(sb);
		if (index != N) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
		
	}
}
