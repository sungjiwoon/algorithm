package b_14_sort;
import java.io.*;
import java.util.*;
/*
 * ���� �� : ī�� 
 * ����
	�رԴ� ���� ī�� N���� ������ �ִ�. ���� ī�忡�� ������ �ϳ� �����ִµ�, �����ִ� ���� -262���� ũ�ų� ����, 262���� �۰ų� ����.
	
	�ر԰� ������ �ִ� ī�尡 �־����� ��, ���� ���� ������ �ִ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ����, ���� ���� ������ �ִ� ������ ���� �������, ���� ���� ����Ѵ�.
	
	�Է�
	ù° �ٿ� �ر԰� ������ �ִ� ���� ī���� ���� N (1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N�� �ٿ��� ���� ī�忡 �����ִ� ������ �־�����.
	
	���
	ù° �ٿ� �ر԰� ���� ���� ������ �ִ� ������ ����Ѵ�.
	
	���� �Է� 1 
	5
	1
	2
	1
	2
	1
	���� ��� 1 
	1
 */
public class B_11652 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long cnt = 0; //���� ���� �ִ� �� 
		long mxval = (long) (Math.pow(2, 62) * (-1)) - 1; //���� ���� ������ ���� ��
		long mxcnt = 0; //���� ���� ������ ���� ���� Ƚ��
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (i == 0 || arr[i] == arr[i-1]) cnt++;
			else {				
				if (cnt > mxcnt) {
					mxcnt = cnt;
					mxval = arr[i-1];
				}
                cnt = 1;
			}
		}
		if (cnt > mxcnt) mxval = arr[n-1];
		System.out.println(mxval);
	}
}
