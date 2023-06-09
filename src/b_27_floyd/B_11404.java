package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * ������ : �÷��̵� (��4)
 * �÷��̵��� ���ʸ� Ǯ �� �ִ� ����
 * �ð� ���⵵�� O(V�� 3��) ��. 
 * 
 * ���̺��� ������ �� �߰��� ���İ��Բ� �� ���Ҹ� 3�� for���� ���� �ٱ��� �ξ���Ѵٴ°� �� ����ϼž� �մϴ�.
 * 
 *  ��ǻ�ʹ� 1�ʿ� 3-5�� ���� ������ �� �� �ִٴ� ��⸦ �߾����ϴ�. 
 *  �� ���ؿ� ���缭 ������ �غ��� ������ 1000���� �� �÷��̵� �˰����� O(n3)���� ����� ��
 *  10���̶� �÷��̵� �˰����� �� �� ���ڴ� ������ �ڵ忡�� �� �� �ֵ� 
 *  �÷��̵� �˰����� �ܼ� ��Ģ������ �ָ� �̷�� ������ ���� 1000�� ���������� �÷��̵� �˰������� Ǯ��� �մϴ�.
 */
public class B_11404 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		long[][] bus = new long[n+1][n+1];
		for (int i = 0; i <= n; i++) 
			for (int j = 0; j <= n; j++) 
				bus[i][j] = Integer.MAX_VALUE;
		
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			bus[a][b] = Math.min(c, bus[a][b]);
			
			
		}
		
		for (int i = 1; i <= n; i++) bus[i][i] = 0;
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {	
					bus[i][j] = Math.min(bus[i][k]+bus[k][j], bus[i][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (bus[i][j] == Integer.MAX_VALUE) bus[i][j] = 0;
				System.out.print(bus[i][j] + " ");
			}
			System.out.println();
		}
	}
}
