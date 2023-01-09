package b_11_square;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
/*���� �� : �����-10
 * ���̵� : ���5
 * �ı� : ��α� ���� ��. �������. 
 * ����

	������� �������� ���� ��� ����. N�� 3�� �ŵ�����(3, 9, 27, ...)�̶�� �� ��, ũ�� N�� ������ N��N ���簢�� ����̴�.
	ũ�� 3�� ������ ����� ������ �ְ�, ����� ������ ��� ĭ�� ���� �ϳ��� �ִ� �����̴�.
	
	***
	* *
	***
	N�� 3���� Ŭ ���, ũ�� N�� ������ �������� ä���� ����� (N/3)��(N/3) ���簢���� ũ�� N/3�� �������� �ѷ��� �����̴�. ���� ��� ũ�� 27�� ������ ���� ��� 1�� ����.
	
	�Է�
	ù° �ٿ� N�� �־�����. N�� 3�� �ŵ������̴�. �� � ���� k�� ���� N=3k�̸�, �̶� 1 �� k < 8�̴�.
	
	���
	ù° �ٺ��� N��° �ٱ��� ���� ����Ѵ�.
	
	���� �Է� 1 ����
	27
	���� ��� 1 ����
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***   ***         ***   ***
	* *   * *         * *   * *
	***   ***         ***   ***
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************

 */
public class B_2447 {
	static char[][] map;
	private static void func(int n, int a, int b) {
		if (n == 1) {
			map[a][b] = '*';
			return;
		}
		
		for (int i = a; i < n+a; i+=n/3) {
			for (int j = b; j < n+b; j+=n/3) {
				if (i >= n/3+a && i < n/3*2+a && j >= n/3+b && j < n/3*2+b) {
					continue;
				} else {
					func(n/3, i, j);
				}
			}
		}
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); 
		map = new char[n][n];
		for (char[] m : map) {
			Arrays.fill(m, ' ');
		}
		func(n, 0, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
