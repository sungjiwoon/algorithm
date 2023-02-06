package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * ȸ�ǽ� ���� (�ǹ� 1) 
	 
	�ð� ����	�޸� ����	����	����	���� ���	���� ����
	2 ��	128 MB	156390	49304	34705	29.711%
	����
	�� ���� ȸ�ǽ��� �ִµ� �̸� ����ϰ��� �ϴ� N���� ȸ�ǿ� ���Ͽ� ȸ�ǽ� ���ǥ�� ������� �Ѵ�. �� ȸ�� I�� ���� ���۽ð��� ������ �ð��� �־��� �ְ�, �� ȸ�ǰ� ��ġ�� �ʰ� �ϸ鼭 ȸ�ǽ��� ����� �� �ִ� ȸ���� �ִ� ������ ã�ƺ���. ��, ȸ�Ǵ� �ѹ� �����ϸ� �߰��� �ߴܵ� �� ������ �� ȸ�ǰ� ������ �Ͱ� ���ÿ� ���� ȸ�ǰ� ���۵� �� �ִ�. ȸ���� ���۽ð��� ������ �ð��� ���� ���� �ִ�. �� ��쿡�� �������ڸ��� ������ ������ �����ϸ� �ȴ�.
	
	�Է�
	ù° �ٿ� ȸ���� �� N(1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N+1 �ٱ��� �� ȸ���� ������ �־����µ� �̰��� ������ ���̿� �ΰ� ȸ���� ���۽ð��� ������ �ð��� �־�����. ���� �ð��� ������ �ð��� 231-1���� �۰ų� ���� �ڿ��� �Ǵ� 0�̴�.
	
	���
	ù° �ٿ� �ִ� ����� �� �ִ� ȸ���� �ִ� ������ ����Ѵ�.
	
	���� �Է� 1 
	11
	1 4
	3 5
	0 6
	5 7
	3 8
	5 9
	6 10
	8 11
	8 12
	2 13
	12 14
	���� ��� 1 
	4
 */

class Pair {
	int first, second;

	public Pair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
	
}
public class B_1931 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		Pair[] meetings = new Pair[n+1];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			meetings[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int ans = 0; 
		int t = 0;
		for (int i = 0; i < n; i++) {
			//������ �ð��� �������� �׸��� �˰���. 
			if (t > meetings[i].first) continue;
			ans++;
			t = meetings[i].second;
		}
		
		System.out.println(ans);
		
	}
}
