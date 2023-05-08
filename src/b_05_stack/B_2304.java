package b_05_stack;

import java.io.*;
import java.util.*;
//Ω∫≈√
public class B_2304 {
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;
		int[] nums = new int[1001];

		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			int index = Integer.parseInt(st[0]);
			nums[index] = Integer.parseInt(st[1]);
			start = Math.min(index, start);
			end = Math.max(index, end);	
		}
		
		Stack<Integer> stack = new Stack<>();
		int tmp = nums[start];
		for (int i = start+1; i <= end; i++) {
			if (nums[i] < tmp) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					int x = stack.pop();
					nums[x] = tmp;
				}
				tmp = nums[i];
			}
		}
		stack.clear();
		
		tmp = nums[end];
		for (int i = end-1; i >= start; i--) {
			if (nums[i] < tmp) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					int x = stack.pop();
					nums[x] = tmp;
				}
				tmp = nums[i];
			}
		}
		
		int res = 0;
		for (int i = start; i <= end; i++) {
			res += nums[i];
		}
		
		
		System.out.println(res);
		
		
	}
}
