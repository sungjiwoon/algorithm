package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * state 변수를 이용해 소수 구하는 법 잘 익혀두기.. 관련 문제 : 에라토스테네스의 체 백준 2960 
 * 베르트랑 공준 성공다국어
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	256 MB	92877	35412	28430	37.985%
문제
베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.

이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.

예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)

자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.

입력의 마지막에는 0이 주어진다.

출력
각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.

제한
1 ≤ n ≤ 123,456
예제 입력 1 
1
10
13
100
1000
10000
100000
0
예제 출력 1 
1
4
3
21
135
1033
8392
 */
public class B_4948 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int max = 123456*2+1;
		boolean[] state = new boolean[max];
		Arrays.fill(state, true);
		state[1] = false;
		for (int i = 2; i < max; i++) {
			if (!state[i]) continue;
			for (int j = 2; j*j < i; j++) {
				if (i % j == 0) {
					state[i] = false; //not 소수
					break;
				}
			}
			//소수 일 경우 뒤쪽 소수의 배수들 전부 false처리. 
			if (state[i]) {
				for (int j = i+i; j <= max; j+=i) {
					state[j] = false;
				}
			}
		}
		
		
		while (n != 0) {
			int cnt = 0;
			
			for (int i = n+1; i <= 2*n; i++) {
				if (state[i]) cnt++;
			}
			
			sb.append(cnt+"\n");
			n = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
		
	}
}
