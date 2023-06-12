package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * ����� ������ (��� 4)
 * �÷��̵� ���� 
 */
public class B_21940 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 3000; //������ ū ���� ä�� �ִ´�. 
			}
			map[i][i] = 0;
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken()); //�ɸ��� �ð�. 
			map[a][b] = t;
		}
		
		int K = Integer.parseInt(br.readLine()); //�ο� ��. 
		ArrayList<Integer> ci = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int k = 0; k < K; k++) ci.add(Integer.parseInt(st.nextToken()));
		//���� �����. 
		
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		//�պ� �ð��� �� . map[i][k] + map[k][i]
		//����� k�� �ð��� Ȯ���ؾ���. 
		//��� ���ø��ٰ� �ƴ϶�, ����� ���� ������ �ȴ�. 
		PriorityQueue<int[]> path = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if(arg0[1] == arg1[1]) return arg0[0] - arg1[0];
				return arg0[1]-arg1[1];
			}
		});
		
		//�պ��ð����� �ִ��� -> �ּڰ��� �Ǵ� �������� ��
		for (int i = 1; i <= n; i++) { //���� x
			int len = 0;
			for (int c : ci) {
				len = Math.max(map[i][c] + map[c][i], len);
			}
			int[] tmp = {i, len};
			path.add(tmp);
		}
		
		int[] res = path.poll();
		System.out.print(res[0] + " ");
		while (!path.isEmpty() && res[1] == path.peek()[1]) {
			System.out.print(path.poll()[0] + " ");
		}
		
		
	}
}









