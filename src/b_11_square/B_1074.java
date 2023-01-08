package b_11_square;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제 명 : Z
 * 문제
	한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 
	예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
	N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.	
	다음 예는 22 × 22 크기의 배열을 방문한 순서이다.	
	
	N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
	
	다음은 N=3일 때의 예이다.	
	입력
	첫째 줄에 정수 N, r, c가 주어진다.
	
	출력
	r행 c열을 몇 번째로 방문했는지 출력한다.
	
	3 7 7 -> 63
	
	** 난이도 실버 1
	* 기본 재귀 문제이다. 
	* 재귀는 역시 어렵다^_^ 
 */
public class B_1074 {
	static int res;
	private void makeZ(int size, int r, int c) {
		if (size == 1) return;
		
//		int pow = (int) (Math.pow(2, size/2));
		//1번 구역
		if (size/2 > r && size/2 > c) {
			makeZ(size/2, r, c); 
		}
		//2번 구역 
		else if (size/2 > r && size/2 <= c) {
			res += size * size / 4;
			makeZ(size/2, r, c-size/2);
		}
		//3번구역
		else if (size/2 <= r && size/2 > c) {
			res += (2 * size/2 * size/2);
			makeZ(size/2, r-size/2, c);
		}
		//4번 구역
//		return ( (int) (Math.pow(2, half) *3))
		else if (size/2 <= r && size/2 <= c) {
			res += (3 * size/2 * size/2); 
			makeZ(size/2, r-size/2, c-size/2);
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = (int) Math.pow(2, N);
		makeZ(size,r,c);
		System.out.println(res);
		
		
		
	}
}
