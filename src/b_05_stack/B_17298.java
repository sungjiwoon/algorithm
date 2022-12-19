package b_05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * ���� �̿�
 * ��� 4
 * ���� object�� ����, �������� �׸�ŭ �ð��� ���� ��
 * �ð� �ʰ� �� 
 * ����� ����, 
 */
public class B_17298 {

	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] nums = new int[N]; //���� �迭
		Stack<Integer> stack = new Stack<>();
		int[] data = new int[N]; //���� �� ����
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			data[i] = value;	
		}
		
		for (int i = 0; i < N; i++) {			

			while (!stack.isEmpty() && data[stack.peek()] <= data[i]) {
				nums[stack.pop()] = data[i];
			}		
			
			stack.push(i);	
			
		}
		
		while (!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}
		for (int i =0; i < N; i++) {
			sb.append(nums[i] + " ");			
		}
		System.out.println(sb);
	}
}
