package b_11_square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * ���� �̸� : ������ ���� 
 * ���̵� : �ǹ� 2
 * �ı� : ȥ�������� Ǯ����! �߰��� �ظ����� �׷��� Ǯ���� ��
 * ����
	N��Nũ���� ��ķ� ǥ���Ǵ� ���̰� �ִ�. ������ �� ĭ���� -1, 0, 1 �� �ϳ��� ����Ǿ� �ִ�. 
	�츮�� �� ����� ������ ���� ��Ģ�� ���� ������ ũ��� �ڸ����� �Ѵ�.
	
	���� ���̰� ��� ���� ���� �Ǿ� �ִٸ� �� ���̸� �״�� ����Ѵ�.
	(1)�� �ƴ� ��쿡�� ���̸� ���� ũ���� ���� 9���� �ڸ���, ������ �߸� ���̿� ���ؼ� (1)�� ������ �ݺ��Ѵ�.
	�̿� ���� ���̸� �߶��� ��, -1�θ� ä���� ������ ����, 0���θ� ä���� ������ ����, 1�θ� ä���� ������ ������ ���س��� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� N(1 �� N �� 37, N�� 3k ��)�� �־�����. ���� N���� �ٿ��� N���� ������ ����� �־�����.
	
	���
	ù° �ٿ� -1�θ� ä���� ������ ������, ��° �ٿ� 0���θ� ä���� ������ ������, ��° �ٿ� 1�θ� ä���� ������ ������ ����Ѵ�.
 */
public class B_1780 {
	static private int[][] borad;
	static int n_1=0, n0=0, n1=0;
	private static void func(int n, int b1, int b2) {		
		boolean isOk = true;
		int a = borad[b1][b2];
		for (int i = b1; i < n+b1; i++) {
			for (int j = b2; j < n+b2; j++) {
				if (a != borad[i][j]) {
					isOk = false;
					break;
				}
				a = borad[i][j];
			}
			if (!isOk) break;
		}
		
		if (!isOk) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					func(n/3, b1+i*n/3, b2+j*n/3);
				}
			}
		} else {
			//System.out.println("-->" + b1 + " " + b2 + " "+borad[b1][b2]);
			if (borad[b1][b2] == 0) n0++;
			else if (borad[b1][b2] == -1) n_1++;
			else if (borad[b1][b2] == 1) n1++;
			return;
		}
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		borad = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				borad[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(n, 0, 0);
		System.out.println(n_1);
		System.out.println(n0);
		System.out.println(n1);
	}
}
