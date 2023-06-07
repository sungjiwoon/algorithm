package b_13_simulation;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * ���� ����ũ 
 * ���̵� : ��3
 * �ð��ʰ� !! -> �ذ� ������ �� �������. 
 */
public class B_16235 {
	static int N,M,K;
	static int[][] new_A, A; 
	static int[][] cnt_v;
	static PriorityQueue[][] trees; 
	/*
	 * 1) �� 
	 * �ڽ��� ���̸�ŭ ����� �԰�, ���� +1
	 *  -> ���� ������ �ϳ��� ĭ�� �ִٸ�, ���� ��������� ����� ����. 
	 *  ����� ������, �ڽ��� ���̸�ŭ ����� �� ������ ����. ���� : 0
	 * 
	 * 2) ����
	 * ���� ���� ������ ������� ����. ���� �����ǳ��� /2 -> ��� �߰�. (�Ҽ��� �Ʒ� ����)
	 * 
	 * 3) ���� 
	 * ���� ���� (��, ���� % 5 == 0) ����, ������ 8���� ĭ�� ���� 1�� ������ ����. 
	 * 
	 * 4) �ܿ� 
	 * ���� ����� �߰�
	 */
	
	private static int spring_summer(int i, int j) {
		int cnt = 0;
		PriorityQueue<Integer> qu = trees[i][j];
		PriorityQueue<Integer> new_q = new PriorityQueue<>();
		if (qu.isEmpty()) return 0;
	
		while (!qu.isEmpty()) {	
			/* ���� ���� */
			if (A[i][j] < qu.peek()) { //���� ���̴� ����. //���� ����. 
				while(!qu.isEmpty()) {
					A[i][j] += qu.poll()/2;
				}
				break;
			}
			int age = qu.poll();
			A[i][j] -= age;
			if ((age+1) % 5 == 0) {
				cnt++;
			}
			new_q.add(age+1); //�ڽ��� ���̸�ŭ ������ ���̴� 1 //���ο� ������ ����!.
			
		}
		
		trees[i][j] = new_q;
		return cnt;
	}
	
	private static void fall(int i, int j, int cnt) {
		int[] dx = {-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};
		for (int k = 0; k < 8; k++) {
			int xx = i+dx[k];
			int yy = j+dy[k];
			if (xx <= 0 || yy <= 0 || xx > N || yy > N) continue;
			PriorityQueue<Integer> tmp = trees[xx][yy];
			for (int kk = 0; kk < cnt; kk++) {
//				System.out.println("���ο� ����! :" + xx+" " + yy + " "+1);
				tmp.add(1);
			}
			trees[xx][yy] = tmp;
		}
	}	
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //�⵵
		new_A = new int[N+1][N+1];
		A = new int[N+1][N+1]; //���. 
		trees = new PriorityQueue[N+1][N+1]; //������ ����
		cnt_v = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				PriorityQueue<Integer> qu = new PriorityQueue<>();
				trees[i][j] = qu;
				A[i][j] = 5;
			}
		}
		
		// �� ó�� ����� ��. : 5. 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				new_A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> qu = trees[x][y];
			qu.add(age);
			trees[x][y] = qu;
			
		}
		
		while (K-- > 0) {
			//�� & ���� 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					cnt_v[i][j]= spring_summer(i, j);
				}
			}
			
			//���� & �ܿ� . 
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					A[i][j] += new_A[i][j]; //�ܿ� 
					if (cnt_v[i][j] == 0) continue;
					fall(i,j,cnt_v[i][j]);
					cnt_v[i][j] = 0;
				}
			}			
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += trees[i][j].size();
			}
		}
		System.out.println(ans);
		
		
	}
}









