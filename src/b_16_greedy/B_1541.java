package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ������ : �Ҿ���� ��ȣ (�ǹ� 2)
 * �ּڰ��� ������ ���� ���ְ� �״��� ������ �������ָ� �ȴ�. 
 * �̰� �� �׸��������� �𸣰�����.. �ϴ� ��Ǯ����. 
 * ����
	�����̴� ����� +, -, �׸��� ��ȣ�� ������ ���� �������. �׸��� ���� �����̴� ��ȣ�� ��� ������.
	
	�׸��� ���� �����̴� ��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ������� �Ѵ�.
	
	��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ����� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� ���� �־�����. ���� ��0��~��9��, ��+��, �׸��� ��-�������� �̷���� �ְ�, ���� ó���� ������ ���ڴ� �����̴�. �׸��� �����ؼ� �� �� �̻��� �����ڰ� ��Ÿ���� �ʰ�, 5�ڸ����� ���� ���ӵǴ� ���ڴ� ����. ���� 0���� ������ �� �ִ�. �Է����� �־����� ���� ���̴� 50���� �۰ų� ����.
	
	���
	ù° �ٿ� ������ ����Ѵ�.
	
	���� �Է� 1 
	55-50+40
	���� ��� 1 
	-35
 */
public class B_1541 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		String s = br.readLine();
		String[] sub = s.split("-");
		
		int sum = Integer.MAX_VALUE;
		for (int i = 0; i < sub.length; i++) {
			int tmp = 0;
			
			String[] add = sub[i].split("\\+");
			for (int j = 0; j < add.length; j++) {
				tmp += Integer.parseInt(add[j]);
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}	
			
		}
		System.out.println(sum);
		
	}
}
