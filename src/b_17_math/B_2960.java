package b_17_math;
import java.io.*;
import java.util.*;

/*
 * 에라토스테네스의 체 성공다국어 (실버 4)
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	1 초	128 MB	22460	12309	10396	55.600%
	문제
	에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
	
	이 알고리즘은 다음과 같다.
	
	2부터 N까지 모든 정수를 적는다.
	아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
	P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
	아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
	N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(1, K) < N ≤ 1000)
	
	출력
	첫째 줄에 K번째 지워진 수를 출력한다.
	
	예제 입력 1 
	7 3
	예제 출력 1 
	6
 */
public class B_2960 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		boolean[] state = new boolean[n+1];
		Arrays.fill(state, true);
		state[1] = false;
		
		for (int i = 2; i <= n; i++) {
			int p = i;
			if (!state[p]) continue;
			for (int j = 2; j*j < p; j++) {
				if (p % j == 0) {
					state[p] = false; //소수 아님.
					break;
				}
			}
			if (state[p]) {
				//소수임. 
				cnt++;
				if (cnt == k) {
					System.out.println(p);
					return;
				}
				for (int j = p+p; j <= n; j+=p) {
					if (state[j]) {
						state[j] = false;
						cnt++;
						
						if (cnt == k) {
							System.out.println(j);
							return;
						}
					}
				}
			} 
		}
		
	}
}
