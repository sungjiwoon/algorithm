package b_13_simulation;

import java.io.*;
import java.util.*;

public class B_14500 {
	static int[][] arr;
	static int n, m;
	
	public void work() throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0;  j < m; j++) {
				
				int sum = 0;
				
				//1
				if (j+3 < m) sum = arr[i][j] + arr[i][j+1]+arr[i][j+2]+arr[i][j+3];
				max = Math.max(sum, max); 
				
				//2
				if (i+3 < n) sum = arr[i][j] + arr[i+1][j]+arr[i+2][j]+arr[i+3][j];
				max = Math.max(sum, max); 
				
				//3
				if (i+1 < n && j+1 < m) sum = arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1];
				max = Math.max(sum, max); 
				
				//4
				if (i+2<n && j+1 <m) sum = arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j+1];
				max = Math.max(sum, max); 
				
				//5
				if (i+2<n && j-1 >= 0) sum = arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j-1];
				max = Math.max(sum, max);
				
				//6
				if (i+2<n && j+1 <m) sum = arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+2][j];
				max = Math.max(sum, max);
				
				//7
				if (i+2<n && j-1 >= 0) sum = arr[i][j-1]+arr[i][j]+arr[i+1][j]+arr[i+2][j];
				max = Math.max(sum, max);
				
				//8
				if (i+1 <n && j+2 < m) sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j];
				max = Math.max(sum, max);
				
				//9
				if (i+1 <n && j+2 < m) sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2];
				max = Math.max(sum, max);
				
				//10
				if (i+2<n && j+1 < m) sum = arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j+1];
				max = Math.max(sum, max);
				
				//11
				if (i+2<n && j+1 < m) sum = arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j];
				max = Math.max(sum, max);
				
				//12
				if (i+1 < n && j+2 <m) sum = arr[i+1][j]+arr[i+1][j+1]+arr[i][j+1]+arr[i][j+2];
				max = Math.max(sum, max);
				
				//13
				if (i+1 < n && j+2 < m) sum = arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2];
				max = Math.max(sum, max);
				
				//14
				if (i+1 < n && j+2 < m) sum = arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i][j+2];
				max = Math.max(sum, max);
				
				//15
				if (i-1 >= 0 && j+2 < m) sum = arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i][j+2];
				max = Math.max(sum, max);
				
				//16
				if (i+2 < n && j-1 >= 0) sum = arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j];
				max = Math.max(sum, max);
				
				//17
				if (i+2 < n && j+1 < m) sum = arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j];
				max = Math.max(sum, max);
				
				//18
				if (i+1<n && j+2 < m) sum = arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2];
				max = Math.max(sum, max);
				
				//19
				if (i+1<n && j+2 < m) sum = arr[i][j+2]+ arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2];
				max = Math.max(sum, max);
				
				
			}
		}
		System.out.println(max);
	}
	
	
	
	
	
	
	
}
