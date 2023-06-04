package b_24_tree;

import java.io.*;
import java.util.*;
/*
 * Ʈ���� ���̿� �ʺ� 
 * ���̵� : ��� 2
 * Ʈ���� ������ȸ�� �̿��ؼ� ������ Ǯ����. 
 */
public class B_2250 {
	static int n;
	static HashMap<Integer, Integer> level = new HashMap<>();
	static HashMap<Integer, int[]> hm = new HashMap<>();
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int[][] levels;
	static int max_level = 1;
	static int col = 1;
	static int[] parent;
	
	/* ��Ʈ ã�� - ���Ͽ� ���ε� �̿� */
	private static int find(int x) {
		if (parent[x] == 0) return x;
		return parent[x] = find(parent[x]);
	}
	
	// �� ��帶�� level ã��. 
	private static void is_level(int par, int lev, int index) {
		
		int left = hm.get(par)[0];
		int right = hm.get(par)[1];
		
		//System.out.println(par + " " + lev + " " + index);
		if (left != -1) {
			level.put(left, lev+1);
			map.put(index*2, left);
			max_level = Math.max(max_level, lev+1);
			is_level(left, lev+1, index*2);			
			
		}
		
		if (right != -1) {
			level.put(right, lev+1);
			map.put(index*2+1,right);
			max_level = Math.max(max_level, lev+1);
			is_level(right, lev+1, index*2+1);			
		} 
		
		return;
		
	}
	
	//���� ��ȸ ���� !. left -> mid -> right. 
	private static void dfs(int index) {
		if (map.get(index) == null) return; //���� ���ٴ� ��. 
		
		dfs(index*2);
		
		int value = map.get(index);
		int i = level.get(value); //value�� ����. 
		System.out.println(i);
		if (levels[i][0] == 0) {
			levels[i][0] = col++;
		} else {
			levels[i][1] = col++;
		}
		
		dfs(index*2+1);
		
	}
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		
		for (int i = 0; i < n; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int par = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			if (left != -1) parent[left] = par;
			if (right != -1) parent[right] = par;
			
			int[] child = {left, right};
			hm.put(par, child);
		}
		
		/* ��Ʈ : ���Ͽ� ���ε� �̿� */
		int root = find(n);
		map.put(1, root);
		level.put(root, 1);
		is_level(root, 1, 1);
		levels = new int[max_level+3][2];
		//System.out.println(root);
		dfs(1);
		int max =0;
		int max_index = 0;
		System.out.println("max_level " + max_level);
		for (int i = 1; i <= max_level; i++) {
			if (levels[i][1] == 0) {
				max = Math.max(max, 1);
				max_index = i;
				continue;
			}
			if (max < levels[i][1]-levels[i][0]+1) {
				max = Math.max(max, levels[i][1]-levels[i][0]+1);
				max_index = i;
			}
		}
		
		System.out.println(max_index + " " + max);
		
		
	}
}
