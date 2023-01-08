import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int[][] borad;
	static int n1 = 0, n0 = 0;
	private static void func(int n, int a, int b) { 
		if (n < 1) return;
		
		/* 배열 안에 같은 값 들어가 있는지 확인. */
		boolean isOk = true;
		int ok = borad[a][b];
		for (int i = a; i < a + n; i++) {
			for (int j = b; j < b + n; j++) {
				if (ok != borad[i][j]) {
					isOk = false;
					break;
				}
				borad[i][j] = ok;
			}
			if (!isOk) break;
		}
		
		if (!isOk) {
			//1구역
			func(n/2, a, b);
			//2구역 
			func(n/2, a + n/2, b);
			//3구역
			func(n/2, a, b + n/2);
			//4구역
			func(n/2, a + n/2, b + n/2);
		} else {
			if (ok == 1) n1++;
			else if (ok == 0) n0++;
			return;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		borad = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				borad[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(n, 0, 0);
		System.out.println(n0); //흰색 종이
		System.out.println(n1); //파랑색 종이.
	}
}
