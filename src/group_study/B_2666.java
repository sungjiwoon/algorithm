package group_study;

import java.io.*;
import java.util.*;

public class B_2666 {
	static int ans = Integer.MAX_VALUE, n, m;
	static int[] seq;
	private static void func(int depth, int sum, int op1, int op2) {
		if (depth == m) {
			ans = Math.min(ans, sum);
			return;
		}
		
		//op1�� ������ ���.
		func(depth+1, sum+Math.abs(seq[depth]-op1), seq[depth], op2);
		//op2�� ������ ���. 
		func(depth+1, sum+Math.abs(seq[depth]-op2), op1, seq[depth]);
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* ���� �ʱ�ȭ ���� */
		n = Integer.parseInt(br.readLine()); //������ ����
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int op1 = Integer.parseInt(st.nextToken()); //�����ִ� ���幮1
		int op2 = Integer.parseInt(st.nextToken()); //�����ִ� ���幮 2
		
		m = Integer.parseInt(br.readLine()); //������ ����
		seq = new int[m]; //������ ������� ��� �迭. 
		for (int i = 0; i < m; i++) seq[i] = Integer.parseInt(br.readLine());
		
		/* ��� ���� */
		
		func(0,0,op1,op2);
		
		/*
		 * ����Ž��, ����� ���� ��� ���������Ѵ�. 
		 * ���� ���� op1�� ������ ���� op2�� ������ ���� ������ ������ش�.
		 * ���� �ִ���̰� 20�̹Ƿ�, 2�� 20�� = �� 1�� �̹Ƿ�, 1���� �ð��� �� �°� ��������. (1�� = �� 1����� ����)
		 * 
		 */
		
		System.out.println(ans);

	}
}



