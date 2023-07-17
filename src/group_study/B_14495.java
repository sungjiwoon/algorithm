package group_study;
import java.io.*;
import java.util.*;

/*
 * 피보나치 비스무리한 수열 (실버4)
 */
public class B_14495 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] f = new long[n+1]; //n의 최댓값인 116은 int형의 범위를 넘어가므로 long 형태로 선언. 
		
		if (n >= 3)f[1] = f[2] = f[3] = 1;		
		else if (n >= 2) f[1] = f[2] = 1;
		else f[1] = 1;
		
		for (int i = 4; i <= n; i++) {
			f[i] = f[i-1] + f[i-3];
		}
		System.out.println(f[n]);
		
	}
}
