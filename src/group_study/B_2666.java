package group_study;

import java.io.*;
import java.util.*;

public class B_2666 {
	static int ans = Integer.MAX_VALUE, n, m;
	static int[] seq;
	private static void func(int depth, int sum, int op1, int op2) {
		if (depth == m) {
			ans = Math.min(ans, sum);
			return;
		}
		
		//op1을 선택할 경우.
		func(depth+1, sum+Math.abs(seq[depth]-op1), seq[depth], op2);
		//op2를 선택할 경우. 
		func(depth+1, sum+Math.abs(seq[depth]-op2), op1, seq[depth]);
		
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 변수 초기화 과정 */
		n = Integer.parseInt(br.readLine()); //벽장의 갯수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int op1 = Integer.parseInt(st.nextToken()); //열려있는 벽장문1
		int op2 = Integer.parseInt(st.nextToken()); //열려있는 벽장문 2
		
		m = Integer.parseInt(br.readLine()); //순서의 길이
		seq = new int[m]; //벽장의 순서대로 담는 배열. 
		for (int i = 0; i < m; i++) seq[i] = Integer.parseInt(br.readLine());
		
		/* 계산 시작 */
		
		func(0,0,op1,op2);
		
		/*
		 * 완전탐색, 경우의 수를 모두 따져봐야한다. 
		 * 벽장 문을 op1을 선택할 때와 op2를 선택할 때를 나누어 계산해준다.
		 * 벽장 최대길이가 20이므로, 2의 20승 = 약 1억 이므로, 1초의 시간에 딱 맞게 떨어진다. (1초 = 약 1억번의 연산)
		 * 
		 */
		
		System.out.println(ans);

	}
}



