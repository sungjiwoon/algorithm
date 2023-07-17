import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {	
	static int ans = 0, n, m;
	static int[] seq;
	private static void func(int depth, int sum, int op1, int op2) {
		if (depth == m) {
			ans = Math.min(ans, sum);
			return;
		}
		
		//op1을 선택할 경우 
		func(depth+1, sum+Math.abs(seq[depth]-op1), seq[depth], op2);
		
		func(depth+1, sum+Math.abs(seq[depth]-op2), op1, seq[depth]);
		
	}
	public static void main(String[] args) throws Exception {	
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
		
		int ans = 0;
		
		System.out.println(ans);
	
	}

}














