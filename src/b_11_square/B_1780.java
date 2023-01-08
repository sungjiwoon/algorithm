package b_11_square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
 * 문제 이름 : 종이의 개수 
 * 난이도 : 실버 2
 * 후기 : 혼자힘으로 풀었다! 중간에 해맸지만 그래도 풀었당 ㅎ
 * 문제
	N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 
	우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
	
	만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
	(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
	이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
	
	출력
	첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 */
public class B_1780 {
	static private int[][] borad;
	static int n_1=0, n0=0, n1=0;
	private static void func(int n, int b1, int b2) {		
		boolean isOk = true;
		int a = borad[b1][b2];
		for (int i = b1; i < n+b1; i++) {
			for (int j = b2; j < n+b2; j++) {
				if (a != borad[i][j]) {
					isOk = false;
					break;
				}
				a = borad[i][j];
			}
			if (!isOk) break;
		}
		
		if (!isOk) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					func(n/3, b1+i*n/3, b2+j*n/3);
				}
			}
		} else {
			//System.out.println("-->" + b1 + " " + b2 + " "+borad[b1][b2]);
			if (borad[b1][b2] == 0) n0++;
			else if (borad[b1][b2] == -1) n_1++;
			else if (borad[b1][b2] == 1) n1++;
			return;
		}
		
	}
	public void work() throws IOException {
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
		System.out.println(n_1);
		System.out.println(n0);
		System.out.println(n1);
	}
}
