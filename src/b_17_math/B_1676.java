package b_17_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 팩토리얼 0의 개수 성공 (실버5)
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	56500	27210	22487	47.903%
문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.

예제 입력 1 
10
예제 출력 1 
2
예제 입력 2 
3
예제 출력 2 
0
 */
public class B_1676 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int i = 1;
		int cnt = 0; //10으로 나눠지는 갯수;
		int cnt2 = 0; //2로 나눠지는 갯수
		int cnt5 = 0; //5로 나눠지는 갯수.
		/* i의 값이 10으로 나눠질려면 2,5 둘다 혹은 10을 소인수로 가져야함 */
		// ex 25 인 경우 -> 5를 두번 나눠줘야하므로 반복문 한번 더 넣음. 
		while (i <= n) {
			int tmp = i;
			while (tmp != 0) {
				if (tmp % 10 == 0) {
					cnt++;
					tmp /= 10;
				}
				else if (tmp % 5 == 0) {
					cnt5++;
					tmp /= 5;
				}
				else if (tmp % 2 == 0) {
					cnt2++;
					tmp /= 2;
				} else {
					break;
				}				
			}
			i++;
		}
		int res = 0;
		if (cnt2 >= cnt5) res += cnt5;
		else res += cnt2;
		res += cnt;
		System.out.println(res);
		
	}
}
