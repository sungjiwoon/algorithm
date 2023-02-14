package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ķ�� �����ٱ���
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	1 ��	128 MB	23698	9367	7964	39.247%
	����
	��갡 �谭���� ������� �Բ� ķ���� ������. ������, ķ���忡�� ������ ���� ����� ���� �־���.
	
	ķ������ �����ϴ� 20�� �� 10�ϵ��ȸ� ����� �� �ֽ��ϴ�.
	
	�����̴� ���� �� 28�� �ް��� �����ߴ�. �̹� �ް� �Ⱓ ���� �����̴� ķ������ ��ĥ���� ����� �� ������?
	
	�����̴� ���� �� �Ϲ�ȭ�ؼ� ������ Ǯ���� �Ѵ�. 
	
	ķ������ �����ϴ� P�� ��, L�ϵ��ȸ� ����� �� �ִ�. �����̴� ���� �� V��¥�� �ް��� �����ߴ�. 
	�����̰� ķ������ �ִ� ��ĥ���� ����� �� ������? (1 < L < P < V)
	
	�Է�
	�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ְ�, L, P, V�� ������� �����ϰ� �ִ�. ��� �Է� ������ int�����̴�. ������ �ٿ��� 0�� 3�� �־�����.
	
	���
	�� �׽�Ʈ ���̽��� ���ؼ�, �����̰� ķ������ �ִ� ��ĥ���� ����� �� �ִ��� ���� ���ó�� ����Ѵ�.
	
	���� �Է� 1 
	5 8 20
	5 8 17
	0 0 0
	���� ��� 1 
	Case 1: 14
	Case 2: 11
 */
public class B_4796 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		
		String s = br.readLine();
		int i = 1;
		while (!s.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(s, " ");
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int res = 0;
			if (v % p < l)
				res = (v / p) * l + (v % p);
			else 
				res = (v / p) * l + l;
			
			System.out.println("Case "+ i +": " + res);
			i++;
			
			s = br.readLine();
		}
	}
}
