package b_19_twopointer;

import java.io.*;
import java.util.*;
/*
 * ���� 0
 * 4��
 * 
 */
public class B_3151 {
	static int n;
	static int[] borad;
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer sto = new StringTokenizer(br.readLine(), " ");
		borad = new int[n];
		
		for (int j = 0; j < n; j++) borad[j] = Integer.parseInt(sto.nextToken());
		
		Arrays.sort(borad);
		long ans = 0;
		for (int i = 0; i < n-2; i++) {
			int fix = i; //ù��° ��. 
			if (borad[fix] > 0) break;
			int st = fix+1; //�ι�° ��.
			int en = n-1; //����° ��. 
			
			while (st < en) {
				int st_n = 1;
				int en_n = 1;
				
				int sum = borad[fix] + borad[st] + borad[en];
				if (sum == 0) {
					if (borad[st] == borad[en]) {
						int tmp = en-st+1;
						ans += (tmp*(tmp-1)/2);
						/*
						 * -10 5 5 5 5 5 -> 5�� ������ �ݺ��ǹǷ�, 
						 * 5C2�� ans�� �ȴ�.
						 */
						break;
					}
					
					while (st+1 < en && borad[st] == borad[st+1]) {
						st_n++;
						st++;
					} //st�� ���� ���� ���� ���
					
					while (st < en-1 && borad[en] == borad[en-1]) {
						en_n++;
						en--;
					} //en�� ���� ���� ���� ���. 
					ans += st_n*en_n;
				}
				
				if (sum < 0) { //������ �� ũ��, ���� �� ���� st�� ���� �ø���. 
					st++;
				} else en--; //�ݴ�. 
			}
		}
		
		System.out.println(ans);
	
	}
	
	/*
	 * �ִ� ����� ���� ������ ���� N �� 10000�̰� �迭�� ��� 0���� �־��� ����̴�.

	�� �� ����� ���� 10000C3 = 166,616,670,000�̹Ƿ� longŸ������ ������ ����ؾ� �Ѵ�.

	�Է°��� ������������ �����Ѵ�.
	<��������>
	���� ���� ��(0�� �ε���)�� fix ��Ű�� 1���ε����� ������ �ε����� start, end�� ���´�.
	�迭�� 0, start, end�� ���� 0���� Ȯ���Ѵ�
	���� 0���� ũ�� end�� ���δ�, 0���� �۰ų� ������ start�� �ø���.
	 */
}
