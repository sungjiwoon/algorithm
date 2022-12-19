package b_05_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
//���5 ����. ž 
// �տ� �ִ� ž�� ������ ���ؼ� ����Ǯ��. 
/*
 * 221219 (��)
 * ��� 5
 * ���� �̸� : 2493 ž 
 * ����� �� �̤�
 * �ٽ�Ǯ���
 */
class Top {
	int num;
	int height;
	Top (int num, int height) {
		this.num = num;
		this.height = height;
	}
}
public class B_2493 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Top> stack = new Stack<Top>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {

			int height = Integer.parseInt(st.nextToken());
			if (stack.isEmpty()) {
				sb.append("0 ");
				stack.push(new Top(i, height));
			} else {
				
				while (true) {
					if (stack.isEmpty()) {
						sb.append("0 ");
						stack.push(new Top(i, height));
						break;
					}
					
					Top top = stack.peek();
					
					if (top.height > height) {
						sb.append(top.num + " ");
						stack.push(new Top(i, height));
						break;
					} else {
						stack.pop();
					}
				}				
			}		
			
		}
		System.out.println(sb);
		br.close();
		
		
	}
}
