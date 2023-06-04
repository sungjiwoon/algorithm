package b_24_tree_unionfind;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * ���Ͽ� ���ε带 �̿��� Ǯ�̸� �����ؾ���. 
 * 
 * �μ��� ���޼��� 
 * ���̵� : ��4
 * 
 */
public class B_20955 {
	static int n;
	static int res =0;
	
	/*���Ͽ� ���ε� */
	static int[] parent;
	private static int find(int x) {
		if (parent[x] == x || parent[x] == 0) //�迭�� �ε����� ���� ���ٸ� �ش� �� ����. or �θ� ���� �� ���. 
			return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return; //�̹� ����Ǿ� �ִٴ� ��. 
		parent[y] = x;
	}
	
	private static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return true;
		return false;
	}
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n+1];
		
		/*
		���Ͽ� ���ε带 Ȱ���� �����Դϴ�.

		������ �Է� �����鼭 merge�� �õ��մϴ�.
		�� ������ �θ� �������� �ʴٸ� merge�� �����մϴ�.
		�� ������ �θ� ������ ���
		�ش� ������ ���ʿ��� �����̹Ƿ�
		�ڸ��� ���� Ƚ���� cnt�� ������ŵ�ϴ�.

		�� ������ �Ϸ��� �ڿ� ���� ���� ���� �� (m - cnt)���� �˴ϴ�.
		���⼭ ������ ������ (n - 1)���� ������ Ȯ���ؾ� Ʈ���� �����˴ϴ�.
		���� �����ؾ� �ϴ� ���� ���� (n - 1) - (m - cnt)���� �˴ϴ�.

		�׷��Ƿ� ������ �հ� �ڸ��� �� ���� ����
		(n - 1) - (m - cnt) + cnt = n - m - 1 + 2*cnt�̸�,
		�̸� ������ ����մϴ�.
		*/
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (!isUnion(a,b)) merge(a,b); //���� �õ�.
			else {
				res++; //���ʿ��� ����. 
			}
		}
		//System.out.println(Arrays.toString(parent));
		
		//���� ������ �� m-res
		res+= (n-1) - (m-res);
		System.out.println(res);
		
		
	}
}
