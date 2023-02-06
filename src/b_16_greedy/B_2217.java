package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * ���� ���� �ǹ� 4
 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	2 ��	192 MB	49752	21715	17432	42.758%
	����
	N(1 �� N �� 100,000)���� ������ �ִ�. �� ������ �̿��Ͽ� �̷� ���� ��ü�� ���ø� �� �ִ�. ������ ������ �� ���⳪ ���̰� �ٸ��� ������ �� �� �ִ� ��ü�� �߷��� ���� �ٸ� ���� �ִ�.
	
	������ ���� ���� ������ ���ķ� �����ϸ� ������ ������ �ɸ��� �߷��� ���� �� �ִ�. k���� ������ ����Ͽ� �߷��� w�� ��ü�� ���ø� ��, ������ �������� ��� ���� w/k ��ŭ�� �߷��� �ɸ��� �ȴ�.
	
	�� �����鿡 ���� ������ �־����� ��, �� �������� �̿��Ͽ� ���ø� �� �ִ� ��ü�� �ִ� �߷��� ���س��� ���α׷��� �ۼ��Ͻÿ�. ��� ������ ����ؾ� �� �ʿ�� ������, ���Ƿ� �� ���� ������ ��� ����ص� �ȴ�.
	
	�Է�
	ù° �ٿ� ���� N�� �־�����. ���� N���� �ٿ��� �� ������ ��ƿ �� �ִ� �ִ� �߷��� �־�����. �� ���� 10,000�� ���� �ʴ� �ڿ����̴�.
	
	���
	ù° �ٿ� ���� ����Ѵ�.
	
	���� �Է� 1 
	2
	10
	15
	���� ��� 1 
	20
 */
public class B_2217 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		int[] roof = new int[n];
		for (int i = 0; i < n; i++) {
			roof[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(roof);
		int mx = 0; 
		
		for (int i = n; i > 0; i--) {
			int ans = i * roof[n-i];
			mx = Math.max(mx, ans);
			
		}
		System.out.println(mx);
	}
}
