package b_17_math;

import java.io.*;
import java.util.*;
/*
 * 분수찾기 성공 실버 5
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (추가 시간 없음)	256 MB	96657	48257	41671	51.231%
문제
무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

1/1	1/2	1/3	1/4	1/5	…
2/1	2/2	2/3	2/4	…	…
3/1	3/2	3/3	…	…	…
4/1	4/2	…	…	…	…
5/1	…	…	…	…	…
…	…	…	…	…	…
이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

출력
첫째 줄에 분수를 출력한다.

예제 입력 1 
1
예제 출력 1 
1/1
예제 입력 2 
2
예제 출력 2 
1/2

문제를 잘 읽자... 멍청아!
 */
public class B_1193 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		
		//int n = Integer.parseInt(br.readLine());
		
		int K = 0;
		int a = 0; 
		int b = a;
		for (int n = 1; n <= 16; n++ ) {
		while (true) {			
			if (a < n && n <= b) {
				int x,y;		
				x = n-a;
				y = K- (n-a) + 1;
				
				if (K % 2 == 0)
					System.out.println(n+" : " + x+"/"+y);
				else 
					System.out.println(n+" : " + y+"/"+x);
				//return;
				break;
			} else {
				K++;
				a = b; 
				b += K;				
			}			
		}
		}
		
	}
}
