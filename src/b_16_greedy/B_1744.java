package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * �� ���� ���� (��� 4)
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	2 ��	128 MB	28798	9009	7247	30.546%
	����
	���̰� N�� ������ �־����� ��, �� ������ ���� ���Ϸ��� �Ѵ�. ������, �׳� �� ������ ���� ��� ���ؼ� ���ϴ� ���� �ƴ϶�, ������ �� ���� �������� �Ѵ�. � ���� �������� �� ��, ��ġ�� ������� ���� �� �ִ�. ������, ���� ��ġ�� �ִ� ��(�ڱ� �ڽ�)�� ���� ���� �Ұ����ϴ�. �׸��� � ���� ���� �Ǹ�, ������ ���� ���� �� ���� ���� ���� ���� �Ŀ� ���Ѵ�.
	
	���� ���, � ������ {0, 1, 2, 4, 3, 5}�� ��, �׳� �� ������ ���� ���ϸ� 0+1+2+4+3+5 = 15�̴�. ������, 2�� 3�� ����, 4�� 5�� ���� �Ǹ�, 0+1+(2*3)+(4*5) = 27�� �Ǿ� �ִ밡 �ȴ�.
	
	������ ��� ���� �� �ѹ��� ���ų�, �ƴϸ� ���� �ʾƾ��Ѵ�.
	
	������ �־����� ��, ������ �� ���� ������ ������ ��, �� ���� �ִ밡 �ǰ� �ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	ù° �ٿ� ������ ũ�� N�� �־�����. N�� 50���� ���� �ڿ����̴�. ��° �ٺ��� N���� �ٿ� ������ �� ���� �־�����. ������ ���� -1,000���� ũ�ų� ����, 1,000���� �۰ų� ���� �����̴�.
	
	���
	���� ���� �ִ밡 ������ ������ �� ���� ����Ѵ�. ������ �׻� 231���� �۴�.
	
	���� �Է� 1 
	4
	-1
	2
	1
	3
	���� ��� 1 
	6
 */
public class B_1744 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long ans = 0;
		int plus_num = 0;
		int minus_num = 0;
		int zero_num = 0;
		int one_num = 0;
		for (int i = n-1; i >= 0; i--) {
		
			if (arr[i] > 1) plus_num++; //2�̻��� ����
			else if (arr[i] < 0) minus_num++; //���� ����
			else if (arr[i] == 0) zero_num++; //0�� ���� (��� ������ ���ص� ����)
			else if (arr[i] == 1) one_num++; //1�� ���� 
			
		}
		for (int i = n-1; i >= n-plus_num; i--) {
			if (i == n-plus_num) {
				System.out.println("����κ� ans += " + arr[i]);
				ans += arr[i];
				System.out.println("����κ� ��� : " + ans);
			}
			else {
				System.out.println("����κ� ans += " + arr[i] + "*" + arr[i-1]);
				ans += arr[i] * arr[i-1];
				System.out.println("����κ� ��� : " + ans);
				i--;
			}
		}
		
		for (int i = n-plus_num-1; i >= n-plus_num-one_num; i--) {
			System.out.println("1 ���ϱ� : " + arr[i]);
			ans += arr[i];
			System.out.println("1 ���ϱ� ��� : " + ans);
		}
		
		System.out.println("minus_num+zero_num = " + (minus_num+zero_num));
		for (int i = 0; i < minus_num+zero_num; i++) {
            if (i < minus_num+zero_num -1 ) {
				System.out.println("�����κ� ans += " + arr[i] + "*" + arr[i+1]);
            	int sum = arr[i] * arr[i+1];
				i++;
				ans += sum;
            } else {
            	System.out.println("�����κ� ans += : " + arr[i]);
                ans += arr[i];
            }
            System.out.println("�����κ� ��� : " + ans);
		}
		//������ ���� ¦�� �� 0�� ���� ¦�� -> ���� ���ʷ� ���ؼ� �����ش�. 
		//������ ���� ¦�� �� 0�� ���� Ȧ�� -> ���� ���ʷ� ���ϰ� 0�� �����ش�. 
		//������ ���� Ȧ�� 0�� ���� ¦�� -> ���� �����ְ� 0�� ���ؼ� �����ش�. 
		//������ ���� Ȧ�� 0�� ���� Ȧ�� -> ���� �����ְ� ������ ���� ���� 0�� ������. ������ 0 ����~
		
		
		System.out.println(ans);
	
		
	}
}
