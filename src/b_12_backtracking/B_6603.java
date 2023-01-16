	package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� �� �ζ� 
 * ���̵� �ǹ� 2
 * ����
	���� �ζǴ� {1, 2, ..., 49}���� �� 6���� ����.
	
	�ζ� ��ȣ�� �����ϴµ� ���Ǵ� ���� ������ ������ 49���� �� �� k(k>6)���� ���� ��� ���� S�� ���� ���� �� ���� ������ ��ȣ�� �����ϴ� ���̴�.
	
	���� ���, k=8, S={1,2,3,5,8,13,21,34}�� ��� �� ���� S���� ���� �� �� �ִ� ����� ���� �� 28�����̴�. ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
	
	���� S�� k�� �־����� ��, ���� ���� ��� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	�Է��� ���� ���� �׽�Ʈ ���̽��� �̷���� �ִ�. �� �׽�Ʈ ���̽��� �� �ٷ� �̷���� �ִ�. ù ��° ���� k (6 < k < 13)�̰�, ���� k�� ���� ���� S�� ���ԵǴ� ���̴�. S�� ���Ҵ� ������������ �־�����.
	
	�Է��� ������ �ٿ��� 0�� �ϳ� �־�����. 
	
	���
	�� �׽�Ʈ ���̽����� ���� ���� ��� ����� ����Ѵ�. �̶�, ���� ������ ����Ѵ�.
	
	�� �׽�Ʈ ���̽� ���̿��� �� ���� �ϳ� ����Ѵ�.
	
	���� �Է� 1 
	7 1 2 3 4 5 6 7
	8 1 2 3 5 8 13 21 34
	0
	���� ��� 1 
	1 2 3 4 5 6
	1 2 3 4 5 7
	1 2 3 4 6 7
	1 2 3 5 6 7
	1 2 4 5 6 7
	1 3 4 5 6 7
	2 3 4 5 6 7
	
	1 2 3 5 8 13
	1 2 3 5 8 21
	1 2 3 5 8 34
	1 2 3 5 13 21
	1 2 3 5 13 34
	1 2 3 5 21 34
	1 2 3 8 13 21
	1 2 3 8 13 34
	1 2 3 8 21 34
	1 2 3 13 21 34
	1 2 5 8 13 21
	1 2 5 8 13 34
	1 2 5 8 21 34
	1 2 5 13 21 34
	1 2 8 13 21 34
	1 3 5 8 13 21
	1 3 5 8 13 34
	1 3 5 8 21 34
	1 3 5 13 21 34
	1 3 8 13 21 34
	1 5 8 13 21 34
	2 3 5 8 13 21
	2 3 5 8 13 34
	2 3 5 8 21 34
	2 3 5 13 21 34
	2 3 8 13 21 34
	2 5 8 13 21 34
	3 5 8 13 21 34
 */
public class B_6603 {
	static int[] arr;
	static int n;
	static int[] res = new int[6];
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();
	private static void func(int idx, int st) {
		if (idx == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = st; i < n; i++) {
			res[idx] = arr[i];
			func(idx+1,i+1);
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			arr = new int[n];
			vis = new boolean[n];
			int i = 0;
			while (st.hasMoreElements()) {
				arr[i++] = Integer.parseInt(st.nextToken());
			}
			System.out.println(Arrays.toString(arr));
			Arrays.sort(arr);
			func(0,0);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
