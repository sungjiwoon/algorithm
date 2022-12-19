package b_05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * 221219 ����
 * ���5, ���������ٹ̱�
 * long Ÿ���� ��������!!!!!!!!!
 */
class Building {
		long see; //�ڽ��� ������ �����Ͽ� �� �� �ִ� ���� �þ��� ����.
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
