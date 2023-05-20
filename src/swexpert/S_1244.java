package swexpert;

import java.io.*;
import java.util.*;

public class S_1244 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int ex = Integer.parseInt(st.nextToken());
			
			int n = s.length(); //ÀÚ¸´ ¼ö 
			
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
			}
			
			int[] copy = new int[n];
			for (int i = 0; i < n; i++) {
				copy[i] = arr[i];
			}
			
			int index = 0;
			if (ex < n)
				Arrays.sort(arr, index, ex);
			
			
			while (ex > 0) {
				Arrays.sort(copy);
				int max = copy[n-1]; //ÃÖ´ñ°ª. 
				
				for (int i = n-1; i >= 0; i--) {
					if (arr[i] == max) {
						int tmp = arr[index];
						arr[index] = arr[i];
						arr[i] = tmp;
						break;
					}
				}
				index++;
				if (index >= n) {
					index = 0;
				}
				ex--;
			}
			
			String res = "";
			for (int i = 0; i < n; i++) res += String.valueOf(arr[i]);
			sb.append("#"+t+ " " + res);
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
