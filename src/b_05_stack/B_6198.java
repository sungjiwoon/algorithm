package b_05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * 221219 스택
 * 골드5, 옥상정원꾸미기
 * long 타입을 조심하자!!!!!!!!!
 */
class Building {
		long see; //자신의 옥상을 포함하여 볼 수 있는 옥상 시야의 갯수.
		int height;
		Building(long see, int height) {
			this.see = see;
			this.height = height;
		}
	}
public class B_6198 {
	
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Building> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {			
			nums[i] = Integer.parseInt(br.readLine());
		}
		long sum = 0;
		for (int i = N-1; i >= 0; i--) {
			Building b = new Building(0, nums[i]);
			if (stack.isEmpty()) {
				stack.push(b);
			} else {			
				while (true) {
					
					if (stack.isEmpty()) {
						stack.push(b);
						break;
					
					} else {
						if (stack.peek().height < b.height) {
							b.see += stack.peek().see + 1;
							stack.pop();
						} else if (stack.peek().height >= b.height) {
							stack.push(b);
							break;
						}
					}
				}
			}
			sum += stack.peek().see;
			//System.out.println(sum);
			
		}
		System.out.println(sum);
		
		
	
	}
}
