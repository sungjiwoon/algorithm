package b_13_simulation;
import java.io.*;
import java.util.Arrays;
/*
 * ������ �����ֱ� (�ǹ� 1)
 * 
 * dfs �̿�
 * ���� ������� ���� ����� !! �ܿ��� ��!!!!!!
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
2 ��	512 MB	81494	42623	27158	49.492%
����
N���� ���� �̷���� ���� A1, A2, ..., AN�� �־�����. ��, ���� �� ���̿� �������� �� �ִ� N-1���� �����ڰ� �־�����. �����ڴ� ����(+), ����(-), ����(��), ������(��)���θ� �̷���� �ִ�.

�츮�� ���� �� ���̿� �����ڸ� �ϳ��� �־, ������ �ϳ� ���� �� �ִ�. �̶�, �־��� ���� ������ �ٲٸ� �� �ȴ�.

���� ���, 6���� ���� �̷���� ������ 1, 2, 3, 4, 5, 6�̰�, �־��� �����ڰ� ����(+) 2��, ����(-) 1��, ����(��) 1��, ������(��) 1���� ��쿡�� �� 60������ ���� ���� �� �ִ�. ���� ���, �Ʒ��� ���� ���� ���� �� �ִ�.

1+2+3-4��5��6
1��2+3+4-5��6
1+2��3��4-5+6
1��2��3-4+5+6
���� ����� ������ �켱 ������ �����ϰ� �տ������� �����ؾ� �Ѵ�. ��, �������� ���� ���������� �� ���Ѵ�. ������ ����� ���� ���� C++14�� ������ ������. ��, ����� �ٲ� �� ���� ���ϰ�, �� ���� ������ �ٲ� �Ͱ� ����. �̿� ����, ���� �� 4���� ����� ����غ��� �Ʒ��� ����.

1+2+3-4��5��6 = 1
1��2+3+4-5��6 = 12
1+2��3��4-5+6 = 5
1��2��3-4+5+6 = 7
N���� ���� N-1���� �����ڰ� �־����� ��, ���� �� �ִ� ���� ����� �ִ��� �Ͱ� �ּ��� ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� ���� N(2 �� N �� 11)�� �־�����. ��° �ٿ��� A1, A2, ..., AN�� �־�����. (1 �� Ai �� 100) ��° �ٿ��� ���� N-1�� 4���� ������ �־����µ�, ���ʴ�� ����(+)�� ����, ����(-)�� ����, ����(��)�� ����, ������(��)�� �����̴�. 

���
ù° �ٿ� ���� �� �ִ� ���� ����� �ִ���, ��° �ٿ��� �ּڰ��� ����Ѵ�. �����ڸ� ��� �����־ �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ���� ����� ������ �Է¸� �־�����. ����, �տ������� ������� ��, �߰��� ���Ǵ� ���� ����� �׻� -10�ﺸ�� ũ�ų� ����, 10�ﺸ�� �۰ų� ����.

���� �Է� 1 
2
5 6
0 0 1 0
���� ��� 1 
30
30
 */
public class B_14888 {
	static int n;
	static int[] nums = new int[101], op = new int[101], op_copy = new int[101];
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static boolean[] vis = new boolean[101];
	
	private static void dfs(int depth) {
		if (depth == n-1) {
			int sum = nums[0];
			for (int i = 0; i < n-1; i++) {
				
				if (op_copy[i] == 0) { //����
					sum += nums[i+1];
				} else if (op_copy[i] == 1) {
					sum -= nums[i+1];
				} else if (op_copy[i] == 2) {
					sum *= nums[i+1];
				} else if (op_copy[i] == 3) {
					if (sum < 0) { //������ ��� 
						sum *= -1;
						sum /= nums[i+1];
						sum *= -1;
					} else 	sum /= nums[i+1];	
				} 
				
			}
			
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < n-1; i++) {
			if (!vis[i]) {
				vis[i] = true;
				op_copy[depth] = op[i];
				dfs(depth+1);
				vis[i] = false;
			}
		}
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(s[i]);
		}
		
		s = br.readLine().split(" ");
		int v = 0;
		for (int i = 0; i < 4; i++) {
			int k = Integer.parseInt(s[i]);
			for (int j = 0; j < k; j++) {
				op[v++] = i;
			}
		}
		
		//System.out.println(Arrays.toString(op));
		dfs(0);
		System.out.println(max);
		System.out.println(min);
		
		
	}
}
