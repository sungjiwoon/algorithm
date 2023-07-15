package b_12_backtracking;

import java.io.*;
import java.util.*;
/*
 * ���� �� : ��ȣ����� 
 * ���̵� : ��� 5(������ �ȵǴµ�???)
 * �ı� : ������! ���ڿ��� sort �Լ� �ȴ�. 
 * ����
	�ٷ� ���� �ֹ��� ������ �� ���踦 �ָӴϿ� ���� ä �����ϰ� ����� �� ������ Ȳ���� ��Ȳ�� ������ ��������, 702ȣ�� ���ο� ���� �ý����� ��ġ�ϱ�� �Ͽ���. �� ���� �ý����� ���谡 �ƴ� ��ȣ�� �����ϰ� �Ǿ� �ִ� �ý����̴�.
	
	��ȣ�� ���� �ٸ� L���� ���ĺ� �ҹ��ڵ�� �����Ǹ� �ּ� �� ���� ����(a, e, i, o, u)�� �ּ� �� ���� �������� �����Ǿ� �ִٰ� �˷��� �ִ�. ���� ���ĵ� ���ڿ��� ��ȣ�ϴ� �������� �������� �̷�� ���� ��ȣ�� �̷�� ���ĺ��� ��ȣ���� �����ϴ� ������ �迭�Ǿ��� ���̶�� �����ȴ�. ��, abc�� ���ɼ��� �ִ� ��ȣ������ bac�� �׷��� �ʴ�.
	
	�� ���� �ý��ۿ��� �������� ��ȣ�� ������� ���� ������ ������ C������ �ִٰ� �Ѵ�. �� ���ĺ��� �Լ��� �ν�, ���� ������ �������� �濡 ħ���ϱ� ���� ��ȣ�� ������ ������ �Ѵ�. C���� ���ڵ��� ��� �־����� ��, ���ɼ� �ִ� ��ȣ���� ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� �� ���� L, C�� �־�����. (3 �� L �� C �� 15) ���� �ٿ��� C���� ���ڵ��� �������� ���еǾ� �־�����. �־����� ���ڵ��� ���ĺ� �ҹ����̸�, �ߺ��Ǵ� ���� ����.
	
	���
	�� �ٿ� �ϳ���, ���������� ���ɼ� �ִ� ��ȣ�� ��� ����Ѵ�.
	
	���� �Է� 1 
	4 6
	a t c i s w
	���� ��� 1 
	acis
	acit
	aciw
	acst
	acsw
	actw
	aist
	aisw
	aitw
	astw
	cist
	cisw
	citw
	istw
 */
public class B_1759 {
	static int l, c;
	static char[] map;
	static StringBuilder sb = new StringBuilder();
	private static void func(int st, String res) {
		if (res.length() == l) {
			int mos = 0;			
			if (res.contains("a")) mos++;
			if (res.contains("e")) mos++;
			if (res.contains("o")) mos++;
			if (res.contains("i")) mos++;
			if (res.contains("u")) mos++;
			if (mos >= 1 && l- mos >= 2) sb.append(res).append("\n");
			
			
			return;
		}
		
		for (int i = st; i < c; i++) {
			String tmp = res;
			res += map[i];
			func(i+1, res);
			res = tmp;
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[c];
		String s = br.readLine();
		for (int i = 0; i < c; i++)
			map[i] = s.charAt(i*2);
		Arrays.sort(map);
		
		func(0,"");
		System.out.println(sb);
	}
}
