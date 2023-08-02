package b_05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

//class NGE {
//	int index;
//	int value;
//	NGE (int index, int value) {
//		this.index = index;
//		this.value = value;
//	}
//}
/*
 * 스택 이용
 * 골드 4
 * 스택 object를 쓰면, 편하지만 그만큼 시간을 많이 씀
 * 시간 초과 뜸 
 * 답안지 참고, 
 */
public class B_17298 {
	static int n;
	static int[] data, res;
	private static void solve() {
		/*
		linkedList 를 쓰면 시간이 더 빨리 걸리는 반에, 메모리를 더 사용하고,
		Stack을 쓰면 시간이 더 오래걸리지만 메모리를 덜 사용함. 미세한 차이임.
		 */
//        LinkedList<Integer> stack = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && data[stack.peek()] < data[i]) {
				res[stack.pop()] = data[i];
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}
	}
	public void work() throws NumberFormatException, IOException {
		input();
		solve();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i< n; i++) sb.append(res[i] + " ");
		System.out.println(sb);

	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		res = new int[n];
	}
}
