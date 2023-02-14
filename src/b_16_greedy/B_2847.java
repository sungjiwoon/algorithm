package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * ������ ���� ������ �����ٱ��� (�ǹ�4)
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	1 ��	128 MB	10318	5425	4686	52.593%
	����
	�б����� �׷��Ƚ� ������ ���� �����̴� �����ð��� ���� ������ �������� ����Ʈ�� ������ �������. ���ӿ��� �� N���� ������ �ְ�, �� ������ Ŭ������ �� ���� ������ �־�����. �÷��̾��� ������ ������ Ŭ�����ϸ鼭 ���� ������ ������, �� ������ �������� �¶��� ������ �ű��. �����̴� ������ ���̵� ������ ��ġ�ߴ�. ������, �Ǽ��� ���� ������ ����� �������� ������ ���� �޴� ��츦 �������.
	
	�� ������ �ذ��ϱ� ���� �����̴� Ư�� ������ ������ ���ҽ�Ű���� �Ѵ�. �̷����ؼ� �� ������ Ŭ������ �� �ִ� ������ �����ϰ� ������� �Ѵ�.
	
	�� ������ Ŭ������ �� ��� ������ �־����� ��, �� �� ���ҽ�Ű�� �Ǵ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. ������ �׻� ����̾�� �ϰ�, 1��ŭ ���ҽ�Ű�� ���� 1���̴�. �׻� ���� �����ϴ� ��츸 �־�����. ������ ���� ������ ��쿡�� ������ ������ ���� �ּ������� �ϴ� ����� ã�ƾ� �Ѵ�.
	
	�Է�
	ù° �ٿ� ������ �� N�� �־�����. (1 �� N �� 100) ���� N�� �ٿ��� �� ������ Ŭ�����ϸ� ��� ������ ù ��° �������� ������ �������� ������� �־�����. ������ 20,000���� ���� ���� �����̴�.
	
	���
	ù° �ٿ� ������ �� �� ���ҽ�Ű�� �Ǵ��� ����Ѵ�.
	
	���� �Է� 1 
	3
	5
	5
	5
	���� ��� 1 
	3
 */
public class B_2847 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[101];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			int v = arr[i];
			for (int j = i-1; j >= 0; j--) {
				if (v <= arr[j]) {
					cnt += (arr[j]-v+1);
					arr[j] -= (arr[j]-v+1);
				}	
				v = arr[j];
			}
		}
		System.out.println(cnt);
		
		
	}
}