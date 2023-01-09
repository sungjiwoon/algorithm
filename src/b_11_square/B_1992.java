package b_11_square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ���� �̸� : ����Ʈ��
 * ���̵� : �ǹ� 1
 * �ı� : ȥ�������� Ǯ����!! ���� 
 * 
 * ����
	��� ������ �����Ͽ� ǥ���ϴ� ������ ������ ���� Ʈ��(Quad Tree)��� ����� �ִ�. �� ���� ��Ÿ���� 0�� ���� ���� ��Ÿ���� 1�θ� �̷���� ����(2���� �迭)���� 
	���� ������ ������ �� ���� ���� ����������, ���� Ʈ�������� �̸� �����Ͽ� ������ ǥ���� �� �ִ�.
	
	�־��� ������ ��� 0���θ� �Ǿ� ������ ���� ����� "0"�� �ǰ�, ��� 1�θ� �Ǿ� ������ ���� ����� "1"�� �ȴ�. ���� 0�� 1�� ���� ������ ��ü�� �� ���� ��Ÿ������ ���ϰ�, 
	���� ��, ������ ��, ���� �Ʒ�, ������ �Ʒ�, �̷��� 4���� �������� ������ �����ϰ� �Ǹ�, �� 4���� ������ ������ ����� ���ʴ�� ��ȣ �ȿ� ��� ǥ���Ѵ�
	
	
	
	�� �׸����� ������ ������ �������� �迭�� ���� ���ڷ� �־�����, �� ������ ���� Ʈ�� ������ �̿��Ͽ� �����ϸ� "(0(0011)(0(0111)01)1)"�� ǥ���ȴ�.  
	N ��N ũ���� ������ �־��� ��, �� ������ ������ ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ��� ������ ũ�⸦ ��Ÿ���� ���� N �� �־�����. N �� ������ 2�� �������� �־�����, 1 �� N �� 64�� ������ ������. �� ��° �ٺ��ʹ� ���� N�� ���ڿ��� N�� ���´�. 
	�� ���ڿ��� 0 �Ǵ� 1�� ���ڷ� �̷���� ������, ������ �� ������ ��Ÿ����.
	
	���
	������ ������ ����� ����Ѵ�.
	
	���� �Է� 1 
	8
	11110000
	11110000
	00011100
	00011100
	11110000
	11110000
	11110011
	11110011
	���� ��� 1 
	((110(0101))(0010)1(0001))
 */
public class B_1992 {
	static int[][] borad;
	private static void func(int n, int a, int b) {
		if (n < 1) {
			return; //base condition
		}
		
		boolean isOk = true;
		int ok = borad[a][b];
		for (int i= a; i < a+n; i++) {
			for (int j = b; j < b+n; j++) {
				if (ok != borad[i][j]) {
					isOk = false;
					break;
				}
			}
			if (!isOk) break;
		}
		
		if(!isOk) {
			System.out.print("(");
			func(n/2, a, b);
			func(n/2, a, b+n/2);
			func(n/2, a+n/2, b);
			func(n/2, a+n/2, b+n/2);
			System.out.print(")");
		} else {
			System.out.print(ok);
		}
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		borad = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				borad[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			}
		}
		
		func(n, 0, 0);
		
		
	}
}
