import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int[] nums = new int[101], op = new int[101], op_copy = new int[101];
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static boolean[] vis = new boolean[101];
	
	private static void dfs(int depth) {
		if (depth == n-1) {
			int sum = nums[0];
			for (int i = 0; i < n-1; i++) {
				
				if (op_copy[i] == 0) { //µ¡¼À
					sum += nums[i+1];
				} else if (op_copy[i] == 1) {
					sum -= nums[i+1];
				} else if (op_copy[i] == 2) {
					sum *= nums[i+1];
				} else if (op_copy[i] == 3) {
					if (sum < 0) { //À½¼öÀÏ °æ¿ì 
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
	public static void main(String[] args) throws NumberFormatException, IOException {
	
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
		
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
	
}
