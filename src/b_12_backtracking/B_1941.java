package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 * ����
	�� 25���� ���л���� �̷���� ���л����� 5��5�� ���簢�� ���� ���·� �ڸ��� ��ġ�Ǿ���, �� ������ �ʾ� �̴ټذ� �ӵ����̶�� �� �л��� �ΰ��� ��Ÿ���� �ٸ� �л����� �־���� �����ߴ�. �� ��� ���л��� ���̴ټ��ġ��� ���ӵ����ġ��� �� �ķ� �������� �Ǿ�����, �� ������ �ʾ� ���ӵ����ġ��� ������ Ȯ���Ű�� ���̴ټ��ġ��� �����ϱ� �����ߴ�.
	
	�����ǽ��� ���� ���̴ټ��ġ��� �л����� ������ ������ ü���� �����ϰ�, ���ҹ��� ĥ���֡��� �Ἲ�ϴ� ���� ������ ���� �������� ���޾Ҵ�. ���ҹ��� ĥ���֡��� ������ ���� ��Ģ�� �����ؾ� �Ѵ�.
	
	�̸��� �̸��� ��ŭ, 7���� ���л���� �����Ǿ�� �Ѵ�.
	���� ��ӷ��� ����, 7���� �ڸ��� ���� ���γ� ���η� �ݵ�� ������ �־�� �Ѵ�.
	ȭ�հ� ������ ����, �ݵ�� ���̴ټ��ġ��� �л���θ� ������ �ʿ�� ����.
	�׷��� ������ ����, ���̴ټ��ġ��� �ݵ�� ������ ���ؾ� �Ѵ�. ���� 7���� �л� �� ���̴ټ��ġ��� �л��� ��� 4�� �̻��� �ݵ�� ���ԵǾ� �־�� �Ѵ�.
	���л����� �ڸ� ��ġ���� �־����� ��, ���ҹ��� ĥ���֡��� �Ἲ�� �� �ִ� ��� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	
	�Է�
	'S'(�̴١��ء����� �л��� ��Ÿ��) �Ǵ� 'Y'(�ӵ����������� �л��� ��Ÿ��)�� ������ ���� 5*5 ����� ���� ���� ù° �ٺ��� �ټ� �ٿ� ���� �־�����.
	
	���
	ù° �ٿ� ���ҹ��� ĥ���֡��� �Ἲ�� �� �ִ� ��� ����� ���� ����Ѵ�.
	
	���� �Է� 1 
	YYYYY
	SYSYS
	YYYYY
	YSYYS
	YYYYY
	���� ��� 1 
	2
	��Ʈ
	������ ����� �Ʒ��� ����.
	
	.....    .....
	SYSYS    SYSYS
	....Y    .Y...
	....S    .S...
	.....    .....
 */
public class B_1941 {
	static char[][] map = new char[5][5];
	static int[] index_map = new int[25];
	static int[] result;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static boolean[] vis = new boolean[25];
	static int count = 0;
	
	private static boolean is_s_ok(int[] result) {
		int res = 0;
		for (int i = 0; i < 7; i++) {
			if (map[result[i]/5][result[i]%5] == 'S') res++;
		}
		if (res>=4) return true;
		return false;
	}
	
	private static void bfs(int[] result) {
		Queue<Pair> qu = new LinkedList<>();
		boolean[] vis2 = new boolean[7];
		int cnt = 1;
		qu.offer(new Pair(result[0]/5, result[0]%5));
		vis2[0] = true;
		
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			
			for (int k = 0; k < 4; k++) {
				int xx = p.X + dx[k];
				int yy = p.Y + dy[k];
				if (xx>=5||xx<0||yy>=5||yy<0) continue;
				
				for (int l = 1; l < 7; l++) {
					if (xx == result[l]/5 && yy == result[l]%5 && !vis2[l]) {
						qu.offer(new Pair(result[l]/5, result[l]%5));
						vis2[l]= true;
						cnt++;
						break;
					}
				}
			}
		}
		if (cnt == 7) {
//			for (int j = 0; j < 7; j++) {
//				System.out.print(result[j]+" ");
//			}
//			System.out.println();
			count++;
		}
	}
	
	private static void func(int idx, int st, int[] result) {
		
		if (idx == 7) {	
			
			if (is_s_ok(result)) {
//				for (int j = 0; j < 7; j++) {
//					System.out.print(result[j]+" ");
//				}
//				System.out.println();
				bfs(result);				
			}
			return;
		}
		
		for (int i = st; i < 25; i++) {
			if (!vis[i]) {
				vis[i] = true;
				result[idx] = i;
				func(idx+1, i, result);
				vis[i] = false;
			}
		}
		
	}
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) 
				map[i][j] = s.charAt(j);
		}
		int n = 1;
		for (int i = 1; i < 25; i++) {
			index_map[i] = i;
		}
		result = new int[7];
		func(0,0, result);
		System.out.println(count);
	}
}
