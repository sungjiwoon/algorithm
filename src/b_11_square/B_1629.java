package b_11_square;

import java.util.Scanner;
/*
 * �ǹ� 1 ������ �⺻ ��Ģ 
 * ����
	�ڿ��� A�� B�� ���� ���� �˰� �ʹ�. �� ���Ϸ��� ���� �ſ� Ŀ�� �� �����Ƿ� 
	�̸� C�� ���� �������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� A, B, C�� �� ĭ�� ���̿� �ΰ� ������� �־�����. 
	A, B, C�� ��� 2,147,483,647 ������ �ڿ����̴�.
	
	���
	ù° �ٿ� A�� B�� ���� ���� C�� ���� �������� ����Ѵ�.
	
	���� �Է� 1 )
	10 11 12
	
	���� ��� 1 )
	4
	
	*****
	*a�� b�� %c = a�� b/2�� %c ���� �Ȱ���. (b�� 2�������� ���� �ȳ������� ��찡 �߿�.)
	*
 */
public class B_1629 {
	long mod(long a, long b, long c) { //�ð����⵵ log n

		if (b == 1) return a % c;
		long val = mod(a, b/2, c);
		if (b % 2 == 0) return val * val % c; // b�� ¦���� �״�� ��ȯ. 
		return (val * val % c) * a % c;
	}
	
	public void work() {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		System.out.println(mod(a,b,c));
	}
}
