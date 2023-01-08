package b_11_square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ���� �� : Z
 * ����
	�Ѽ��� ũ�Ⱑ 2N �� 2N�� 2���� �迭�� Z������� Ž���Ϸ��� �Ѵ�. 
	���� ���, 2��2�迭�� ���� ��ĭ, ������ ��ĭ, ���� �Ʒ�ĭ, ������ �Ʒ�ĭ ������� �湮�ϸ� Z����̴�.
	N > 1�� ���, �迭�� ũ�Ⱑ 2N-1 �� 2N-1�� 4��� �� �Ŀ� ��������� ������� �湮�Ѵ�.	
	���� ���� 22 �� 22 ũ���� �迭�� �湮�� �����̴�.	
	
	N�� �־����� ��, r�� c���� �� ��°�� �湮�ϴ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	������ N=3�� ���� ���̴�.	
	�Է�
	ù° �ٿ� ���� N, r, c�� �־�����.
	
	���
	r�� c���� �� ��°�� �湮�ߴ��� ����Ѵ�.
	
	3 7 7 -> 63
	
	** ���̵� �ǹ� 1
	* �⺻ ��� �����̴�. 
	* ��ʹ� ���� ��ƴ�^_^ 
 */
public class B_1074 {
	static int res;
	private void makeZ(int size, int r, int c) {
		if (size == 1) return;
		
//		int pow = (int) (Math.pow(2, size/2));
		//1�� ����
		if (size/2 > r && size/2 > c) {
			makeZ(size/2, r, c); 
		}
		//2�� ���� 
		else if (size/2 > r && size/2 <= c) {
			res += size * size / 4;
			makeZ(size/2, r, c-size/2);
		}
		//3������
		else if (size/2 <= r && size/2 > c) {
			res += (2 * size/2 * size/2);
			makeZ(size/2, r-size/2, c);
		}
		//4�� ����
//		return ( (int) (Math.pow(2, half) *3))
		else if (size/2 <= r && size/2 <= c) {
			res += (3 * size/2 * size/2); 
			makeZ(size/2, r-size/2, c-size/2);
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);
		makeZ(size,r,c);
		System.out.println(res);
		
		
		
	}
}
