package b_13_simulation;
import java.io.*;
import java.util.*;

public class B_14891 {
	static int[][] arr = new int[4][8];
//	static int[][] dir = {{2,6},{2,6},{2,6},{2,6}};
	static int[] dir12 = {8,8,8,8};
	private static void rotate(int dir, int index) {
		if (dir == -1) {
			dir12[index]++;
		} else {
			dir12[index]--;
		}
	}
	private static boolean is_samevalue(int a) {
		return (arr[a][(dir12[a]+2)%8] != arr[a+1][(dir12[a+1]+6)%8]) ? false : true;
	}
	public void work() throws IOException {
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
			
			if (index == 1) {
				
			} else if (index == 2) {
				
			} else if (index == 3) {
				
			} else {
				
			}
			
			
			while (true) {
				rotate(dir, index);
				if (index != 1 && !is_samevalue(index-1)) {
					rotate(dir*(-1), index-1);
				}
				
				if (index != 4 && !is_samevalue(index)) {
					rotate(dir*(-1), index+1);
				}
				
			}
		}
	}
}
