package b_13_simulation;
import java.io.*;
import java.util.*;
/*
 * ������ : ��Ϲ���
 * ���̵� : ��� 5
 * ����
	�� 8���� ��ϸ� ������ �ִ� ��Ϲ��� 4���� �Ʒ� �׸��� ���� �Ϸķ� ������ �ִ�. ��, ��ϴ� N�� �Ǵ� S�� �� �ϳ��� ��Ÿ���� �ִ�. 
	��Ϲ������� ��ȣ�� �Ű��� �ִµ�, ���� ���� ��Ϲ����� 1��, �� �������� 2��, �� �������� 3��, ���� ������ ��Ϲ����� 4���̴�.	
	�̶�, ��Ϲ����� �� K�� ȸ����Ű���� �Ѵ�. ��Ϲ����� ȸ���� �� ĭ�� �������� �Ѵ�. ȸ���� �ð� ����� �ݽð� ������ �ְ�, �Ʒ� �׸��� ���� ȸ���Ѵ�.
	
	��Ϲ����� ȸ����Ű����, ȸ����ų ��Ϲ����� ȸ����ų ������ �����ؾ� �Ѵ�. ��Ϲ����� ȸ���� ��, ���� �´��� �ؿ� ���� ���� �ִ� ��Ϲ����� ȸ����ų ���� �ְ�, ȸ����Ű�� ���� ���� �ִ�. 
	��Ϲ��� A�� ȸ���� ��, �� ���� �ִ� ��Ϲ��� B�� ���� �´��� ����� ���� �ٸ��ٸ�, B�� A�� ȸ���� ����� �ݴ�������� ȸ���ϰ� �ȴ�. ���� ���, �Ʒ��� ���� ��츦 ���캸��.
	
	�� ��Ϲ����� �´��� �κ��� �ʷϻ� �������� �����ִ� �κ��̴�. ���⼭, 3�� ��Ϲ����� �ݽð� �������� ȸ���ߴٸ�, 4�� ��Ϲ����� �ð� �������� ȸ���ϰ� �ȴ�. 
	2�� ��Ϲ����� �´��� �κ��� S������ ���� ���� ������, ȸ������ �ʰ� �ǰ�, 1�� ��Ϲ����� 2���� ȸ������ �ʾұ� ������, ȸ������ �ʰ� �ȴ�. ����, �Ʒ� �׸��� ���� ����� ����� �ȴ�.

	���� ���� ���¿��� 1�� ��Ϲ����� �ð� �������� ȸ����Ű��, 2�� ��Ϲ����� �ݽð� �������� ȸ���ϰ� �ǰ�, 2���� ȸ���ϱ� ������, 3���� ���ÿ� �ð� �������� ȸ���ϰ� �ȴ�. 
	4���� 3���� ȸ��������, �´��� ���� ���� ������ ȸ������ �ʴ´�. ����, �Ʒ��� ���� ���°� �ȴ�.

	��Ϲ����� �ʱ� ���¿� ��Ϲ����� ȸ����Ų ����� �־����� ��, ���� ��Ϲ����� ���¸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� 1�� ��Ϲ����� ����, ��° �ٿ� 2�� ��Ϲ����� ����, ��° �ٿ� 3�� ��Ϲ����� ����, ��° �ٿ� 4�� ��Ϲ����� ���°� �־�����. ���´� 8���� ������ �̷���� �ְ�, 
	12�ù������ �ð���� ������� �־�����. N���� 0, S���� 1�� ��Ÿ���ִ�.
	
	�ټ�° �ٿ��� ȸ�� Ƚ�� K(1 �� K �� 100)�� �־�����. ���� K�� �ٿ��� ȸ����Ų ����� ������� �־�����. �� ����� �� ���� ������ �̷���� �ְ�, ù ��° ������ ȸ����Ų ��Ϲ����� ��ȣ, 
	�� ��° ������ �����̴�. ������ 1�� ���� �ð� �����̰�, -1�� ���� �ݽð� �����̴�.
	
	���
	�� K�� ȸ����Ų ���Ŀ� �� ��Ϲ����� ������ ���� ����Ѵ�. ������ ������ ���� ����Ѵ�.

	1�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 1��
	2�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 2��
	3�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 4��
	4�� ��Ϲ����� 12�ù����� N���̸� 0��, S���̸� 8��
	���� �Է� 1 
	10101111
	01111101
	11001110
	00000010
	2
	3 -1
	1 1
	���� ��� 1 
	7
 */
public class B_14891 {
	static int[][] arr = new int[4][8];
	static int[] dir12 = {80,80,80,80}; //���� ���� 
	private static void func(int index, int dir, int same) {
		if (index > 3 || index < 0) return;
		
		if (index > 0 && !is_samevalue(index-1) && index-1 != same) {
			//rotate(dir, index-1);
			func(index-1, dir*(-1), index);			
			//System.out.println("hi"+index+ " : " + (index-1) + " vs " + index);
		}
		
		if (index < 3 && !is_samevalue(index) && index+1 != same) {
			//rotate(dir, index+1);
			func(index+1, dir*(-1), index);
			//System.out.println("hi"+index+ " : "+ (index) + " vs " + (index+1) );
		}
		rotate(dir, index);
	}
	private static void rotate(int dir, int index) {
		if (dir == -1) {
			dir12[index]++;
		} else {
			dir12[index]--;
		}
	}
	private static boolean is_samevalue(int a) {
		return (arr[a][(dir12[a]+2)%8] != arr[a+1][(dir12[a+1]+6)%8]) ? false: true;
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));	
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());			
			
			//rotate(dir, index-1);
			func(index-1, dir, index-1);
			//System.out.println(Arrays.toString(dir12));
		}
		
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count += Math.pow(2, i)*arr[i][dir12[i]%8];
		}
		System.out.println(count);
	}
}
