package b_18_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * �� ���� �� ���� ���4
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	1 ��	128 MB	5784	1605	1104	27.942%
	����
	N(5 �� N �� 1,000)���� �ڿ������ �̷���� ���� U�� �ִ�. �� �߿��� ������ �� ���� ����� ��, 
	�� �� ���� �� d�� U�ȿ� ���ԵǴ� ��찡 ���� �� �ִ�. �̷��� ���� �߿���, ���� ū d�� ã����.
	
	���� ��� {2, 3, 5, 10, 18}�� ���� ������ �ִٰ� ����. 2+3+5 = 10�� �ǰ�, �� ���� ���տ� ���Եȴ�. ������ 3+5+10 = 18�� �ǰ�, 
	�� ��찡 �� ���� ���� ���� Ŀ���� ����̴�.
	
	�Է�
	ù° �ٿ� �ڿ��� N�� �־�����. ���� N���� �ٿ� ���ʷ� U�� ���Ұ� �ϳ��� �־�����. �־��� U�� ������ �ǹǷ� �ԷµǴ� �� ���� ���Ƽ��� �� �ȴ�. 
	U�� ���Ҵ� 200,000,000���� �۰ų� ���� �ڿ����̴�. ���� �׻� �����ϴ� ��츸 �Է����� �־�����.
	
	���
	�츮�� x��° ��, y��° ��, z��° ���� ���ؼ� k��° ���� ������ٶ�� ����. ���� �������� 2+3+5=10�� ���� x, y, z, k�� 
	���ʷ� 1, 2, 3, 4�� �Ǹ�, �������� ���� 2, 3, 4, 5�� �ȴ�. k��° ���� �ִ밡 �ǵ��� �ϴ� ���� �����̴�. 
	x, y, z, k�� ���� ���Ƶ� �ȴ�. �̶�, k��° ���� ����ϸ� �ȴ�.
	
	���� �Է� 1 
	5
	2
	3
	5
	10
	18
	���� ��� 1 
	18
 */
public class B_2295 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */	
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int index = 0;
		int[] sum = new int[n*n];
		//Map<Integer, Integer> two = new HashMap<>();
		
		/* ���� ��� 
		 * �迭�� 3���� ���� ���̴ϱ�,
		 * �μ����� �ϴ� �� ���Ѱ��� �迭�� ���� �ִ´�. 
		 * �׸��� �ϳ��� �����ָ鼭 �ִ��� ã�´�. 
		 * sum[index] + a[k] = a[l]
		 * a[l]-a[k] = sum[index] -> �̰� �̿���. 
		 */
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			//sorted.put(a[i], i); //index �� ã���. 
		}
		Arrays.sort(a);
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum[index++] = a[i]+a[j];
			}
		}
		Arrays.sort(sum,0,index-1);
		
		for (int i = n-1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				if (Arrays.binarySearch(sum, a[i]-a[j]) < 0) continue;
				// -> �� �Լ����� index ���� ������ ������ ��ȯ����. 
					
				System.out.println(a[i]); //���� ū ���̴ϱ�. 
				return;
				
			}
		}

	}
}
