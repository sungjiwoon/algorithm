package b_11_square;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B_2448 {
	static char[][] map;
	private static void func(int n, int a, int b) {
		if (n == 1) {
			map[a][b] = '*';
			return;
		}
		
		for (int i = a; i < n+a; i+=n/3) {
			for (int j = b; j < n+b; j+=n/3) {
				if (i >= n/3+a && i < n/3*2+a && j >= n/3+b && j < n/3*2+b) {
					continue;
				} else {
					func(n/3, i, j);
				}
			}
		}
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); 
		map = new char[n][n];
		for (char[] m : map) {
			Arrays.fill(m, ' ');
		}
		func(n, 0, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
