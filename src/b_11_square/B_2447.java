package b_11_square;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
/*문제 명 : 별찍기-10
 * 난이도 : 골드5
 * 후기 : 블로그 업뎃 완. 어려웠다. 
 * 문제

	재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
	크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
	
	***
	* *
	***
	N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
	
	입력
	첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
	
	출력
	첫째 줄부터 N번째 줄까지 별을 출력한다.
	
	예제 입력 1 복사
	27
	예제 출력 1 복사
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***   ***         ***   ***
	* *   * *         * *   * *
	***   ***         ***   ***
	*********         *********
	* ** ** *         * ** ** *
	*********         *********
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************
	***   ******   ******   ***
	* *   * ** *   * ** *   * *
	***   ******   ******   ***
	***************************
	* ** ** ** ** ** ** ** ** *
	***************************

 */
public class B_2447 {
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
