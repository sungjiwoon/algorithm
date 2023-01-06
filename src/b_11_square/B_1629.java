package b_11_square;

import java.util.Scanner;
/*
 * 실버 1 곱셈의 기본 규칙 
 * 문제
	자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 
	이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. 
	A, B, C는 모두 2,147,483,647 이하의 자연수이다.
	
	출력
	첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
	
	예제 입력 1 )
	10 11 12
	
	예제 출력 1 )
	4
	
	*****
	*a의 b승 %c = a의 b/2승 %c 값이 똑같다. (b가 2나눠지는 경우와 안나눠지는 경우가 중요.)
	*
 */
public class B_1629 {
	long mod(long a, long b, long c) { //시간복잡도 log n

		if (b == 1) return a % c;
		long val = mod(a, b/2, c);
		if (b % 2 == 0) return val * val % c; // b가 짝수면 그대로 반환. 
		return (val * val % c) * a % c;
	}
	
	public void work() {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		System.out.println(mod(a,b,c));
	}
}
