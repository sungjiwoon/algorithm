import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr = new int[4][8];
	static int[] dir12 = {8,8,8,8};
	private static void func(int index, int dir, int same) {
		if (index > 3 || index < 0) return;
		
		if (index > 0 && !is_samevalue(index-1) && index-1 != same) {
			func(index-1, dir*(-1), index);			
		}
		
		if (index < 3 && !is_samevalue(index) && index+1 != same) {
			func(index+1, dir*(-1), index);
		}
		rotate(dir, index);
	}
	private static void rotate(int dir, int index) {
		if (dir == -1) {
			dir12[index]++;
		} else {
			dir12[index]--;
		}
	}
	private static boolean is_samevalue(int a) {
		return (arr[a][(dir12[a]+2)%8] != arr[a+1][(dir12[a+1]+6)%8]) ? false: true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));	
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int index = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());			
			
			func(index-1, dir, index-1);
		}
		
		int count = 0;
		for (int i = 0; i < 4; i++) {
			count += Math.pow(2, i)*arr[i][dir12[i]%8];
		}
		System.out.println(count);
		
	}
}
