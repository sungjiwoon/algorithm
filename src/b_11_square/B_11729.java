package b_11_square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*
 * ���� �̸� : �ϳ���ž �̵� ����
 * ���̵� : �ǹ� 1 
 * �ı� : �⺻ �⺻ ��� �ܰ� ���� ����!!
 * ������ ������� �׷��� �ذ��س����� �ִ� .  
 * ����
	�� ���� ��밡 �ְ� ù ��° ��뿡�� �ݰ��� ���� �ٸ� n���� ������ �׿� �ִ�. �� ������ �ݰ��� ū ������� �׿��ִ�. ���� �����µ��� ���� ��Ģ�� ���� ù ��° ��뿡�� �� ��° ���� �ű�� �Ѵ�.
	
	�� ���� �� ���� ���Ǹ��� �ٸ� ž���� �ű� �� �ִ�.
	�׾� ���� ������ �׻� ���� ���� �Ʒ��� �ͺ��� �۾ƾ� �Ѵ�.
	�� �۾��� �����ϴµ� �ʿ��� �̵� ������ ����ϴ� ���α׷��� �ۼ��϶�. ��, �̵� Ƚ���� �ּҰ� �Ǿ�� �Ѵ�.
	
	�Ʒ� �׸��� ������ 5���� ����� �����̴�.
	
	�Է�
	ù° �ٿ� ù ��° ��뿡 ���� ������ ���� N (1 �� N �� 20)�� �־�����.
	
	���
	ù° �ٿ� �ű� Ƚ�� K�� ����Ѵ�.
	
	�� ��° �ٺ��� ���� ������ ����Ѵ�. �� ��° �ٺ��� K���� �ٿ� ���� �� ���� A B�� ��ĭ�� ���̿� �ΰ� ����ϴµ�, �̴� A��° ž�� ���� ���� �ִ� ������ B��° ž�� ���� ���� �ű�ٴ� ���̴�.
 */
public class B_11729 {
	static StringBuffer sb;
	public void hanoi(int N, int start, int mid, int end) {
		if (N == 1) {
			sb.append(start+" "+end+"\n");
			return;
		}
		
		// 1) ���� n-1 ���� �̵� �߰��� �̵��ؾ���. 
		hanoi(N-1, start, end, mid);
		// 2) ���� 1���� start -> end�������� �̵�.
		sb.append(start+" "+end+"\n");
		//3) ���� N-1���� mid -> end �������� �̵�. 
		hanoi(N-1, mid ,start, end);
		
	
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int count = (int) (Math.pow(2, N)-1);
		sb.append(count+"\n");
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}
}
